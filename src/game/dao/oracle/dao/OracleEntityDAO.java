package game.dao.oracle.dao;

//import OCDConsole;
import game.dao.interfaces.EntityDAO;
import game.dao.entities.Entity;
import game.dao.oracle.OracleDAOFactory;
import game.view.controllers.MainController;

import java.sql.*;

/**
 * Created by hugoc on 28/11/2016.
 */

public class OracleEntityDAO implements EntityDAO{
    private Connection con;

    public OracleEntityDAO() {
        con = OracleDAOFactory.getConnection();
    }

    @Override
    public boolean changeStatus(Entity entity, String status) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call changeStatus(?, ?)}");
            stm.setInt(1, entity.getId());
            stm.setString(2, status);
            stm.execute();
            return true;
        } catch (SQLException e) {
            MainController.printLog(e.getMessage());
        } finally {
            OracleDAOFactory.closeStatement(stm);
        }
        return false;
    }

    @Override
    public Entity find(int entityId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Entity entity = null;
        try {
            stm = con.prepareStatement("SELECT * FROM Entity WHERE entityID = ?");
            stm.setInt(1, entityId);
            rs = stm.executeQuery();
            if (rs.next()) {
                entity = new Entity(
                        rs.getInt("entityID"),
                        rs.getLong("rooms"),
                        rs.getInt("inventoryID"),
                        rs.getInt("equipmentID"),
                        rs.getDouble("money"),
                        rs.getInt("health"),
                        rs.getInt("maxHealth"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            MainController.printLog(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return entity;
    }
}