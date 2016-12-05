package game.dao.oracle.dao;

import game.dao.interfaces.MonsterDAO;
import game.dao.entities.Adventurer;
import game.dao.entities.Monster;
import game.dao.oracle.OracleDAOFactory;
import game.view.controllers.LayoutController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hugoc on 28/11/2016.
 */

public class OracleMonsterDAO implements MonsterDAO{

    private Connection con;

    public OracleMonsterDAO() {
        con = OracleDAOFactory.getConnection();
    }

    @Override
    public Monster getCurrentMonsterOfAdventurer(Adventurer adventurer) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Monster monster = null;
        try {
            stm = con.prepareStatement("SELECT m.*, mn.* FROM MonsterName mn, Monster m, Dungeon d, Adventurer a, Entity e " +
                    "WHERE m.nameID = mn.monsterNameID " +
                    "AND m.monsterID = d.monsterID " +
                    "AND d.dungeonID = a.dungeonID " +
                    "AND a.entityID = e.entityID " +
                    "AND a.adventurerID = ?");
            stm.setInt(1, adventurer.getId());
            rs = stm.executeQuery();
            if (rs.next()) {
                monster = new Monster(
                        rs.getInt("monsterID"),
                        rs.getInt("monsterNameID"),
                        rs.getString("name"),
                        rs.getInt("entityID")
                );
            }
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return monster;
    }
}