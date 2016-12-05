package game.dao.oracle;

import game.dao.DAOFactory;

import game.dao.interfaces.LordDAO;
import game.dao.interfaces.AdventurerDAO;
import game.dao.interfaces.EntityDAO;
import game.dao.interfaces.MonsterDAO;
import game.dao.interfaces.InventoryDAO;
import game.dao.interfaces.ItemDAO;

import game.dao.oracle.dao.OracleLordDAO;
import game.dao.oracle.dao.OracleAdventurerDAO;
import game.dao.oracle.dao.OracleEntityDAO;
import game.dao.oracle.dao.OracleMonsterDAO;
import game.dao.oracle.dao.OracleInventoryDAO;
import game.dao.oracle.dao.OracleItemDAO;
import game.view.controllers.LayoutController;
import game.view.controllers.MainController;

import java.sql.*;


/**
 * Created by t00191729 on 24/11/2016.
 */

public class OracleDAOFactory extends DAOFactory {
    private static String connectionUrl;
    private static String username;
    private static String password;
    private static Connection con;

    public OracleDAOFactory() {
        con = getConnection();
        connectionUrl = "localhost";
        username = "hippykachuOCD";
        password = "ocd";
    }

    @Override
    public LordDAO getLordDAO() {
        return new OracleLordDAO();
    }

   @Override
    public AdventurerDAO getAdventurerDAO() {
        return new OracleAdventurerDAO();
    }

    @Override
    public EntityDAO getEntityDAO() {
        return new OracleEntityDAO();
    }

    @Override
    public MonsterDAO getMonsterDAO() {
        return new OracleMonsterDAO();
    }

    @Override
    public InventoryDAO getInventoryDAO() {
        return new OracleInventoryDAO();
    }
    @Override
    public ItemDAO getItemDAO() {
        return new OracleItemDAO();
    }

    public static Connection getConnection() {
        if(con == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@" + connectionUrl, username, password);
                MainController.printError("Successfully connected to the database!");
                return con;
            } catch (ClassNotFoundException e) {
                MainController.printError("Where is your Oracle JDBC Driver?");
            } catch (SQLException e) {
                MainController.printError("Connection to database failed: " + e.getMessage());
            }
            return null;
        } else {
            return con;
        }
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            MainController.printError("Error closing the connection: " + e.getMessage());
        }
    }

    public static void closeStatement(Statement stm) {
        try {
            if(stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            MainController.printError("Error closing statement");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            MainController.printError("Error closing resultSet");
        }
    }
}
