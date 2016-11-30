package dao.oracle.dao;

import dao.entities.Lord;
import dao.interfaces.LordDAO;
import dao.oracle.OracleDAOFactory;
import view.controllers.LayoutController;

import java.sql.*;

/**
 * Created by t00191729 on 24/11/2016.
 */

public class OracleLordDAO implements LordDAO {

    private Connection con;

    public OracleLordDAO() {
        con = OracleDAOFactory.getConnection();
    }

    @Override
    public boolean createLord(String login, String pass1, String pass2) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call createLord(?, ?, ?)}");
            stm.setString(1, login);
            stm.setString(2, pass1);
            stm.setString(3, pass2);
            stm.execute();
            return true;
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeStatement(stm);
        }
        return false;
    }

    @Override
    public Lord connectUser(String login, String password) {
        CallableStatement stm = null;
        Lord lord = null;
        try {
            stm = con.prepareCall("{? = call connectUser(?, ?)}");
            stm.registerOutParameter(1, Types.INTEGER);
            stm.setString(2, login);
            stm.setString(3, password);
            stm.execute();
            int lordID = stm.getInt(1);
            lord = find(lordID);
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeStatement(stm);
        }
        return lord;
    }

    @Override
    public boolean switchAdventurer(Lord lord, int adventurerID) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call switchAdventurer(?, ?)}");
            stm.setInt(1, lord.getId());
            stm.setInt(2, adventurerID);
            stm.execute();
            return true;
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        }
        return false;
    }

    @Override
    public Lord find(int lordID) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Lord lord = null;
        try {
            stm = con.prepareStatement("SELECT * FROM Lord WHERE lordID = ?");
            stm.setInt(1, lordID);
            rs = stm.executeQuery();
            if (rs.next()) {
                lord = new Lord(
                        rs.getInt("lordID"),
                        rs.getString("login"),
                        rs.getBoolean("blocked"),
                        rs.getInt("currentAdventurer")
                );
            }
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return lord;
    }
}