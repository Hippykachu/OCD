package dao.oracle.dao;

import dao.interfaces.ItemDAO;
import dao.entities.Adventurer;
import dao.entities.Item;
import dao.oracle.OracleDAOFactory;
import view.controllers.LayoutController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public class OracleItemDAO implements ItemDAO {
    private Connection con;

    public OracleItemDAO() {
        con = OracleDAOFactory.getConnection();
    }

    @Override
    public List<Item> consultShop(Adventurer adventurer) {
        return consult("consultShop", adventurer);
    }

    @Override
    public List<Item> consultLoot(Adventurer adventurer) {
        return consult("consultLoot", adventurer);
    }

    private List<Item> consult(String function, Adventurer adventurer) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Item> results = new ArrayList<>();
        try {
            stm = con.prepareStatement("SELECT * FROM TABLE(" + function + "(?))");
            stm.setInt(1, adventurer.getId());
            rs = stm.executeQuery();
            while (rs.next()) {
                results.add(new Item(
                        rs.getInt("itemID"),
                        rs.getInt("typeID"),
                        rs.getString("itemName"),
                        rs.getString("typeName"),
                        rs.getDouble("price"),
                        rs.getDouble("roomsToEquip"),
                        rs.getInt("bonusHealth"),
                        rs.getInt("bonusDefense"),
                        rs.getInt("bonusAttack"),
                        rs.getInt("bonusCritical")
                ));
            }
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return results;
    }
}