package dao.oracle;

import dao.DAOFactory;
import dao.interfaces.LordDAO;
import dao.oracle.dao.OracleLordDAO;

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
        connectionUrl = "adress";
        username = "test";
        password = "test";
    }

    @Override
    public LordDAO getLordDAO() {
        return new OracleLordDAO();
    }

    public static Connection getConnection() {
        if(con == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@" + connectionUrl, username, password);
                OCDConsole.printlnSuccess("Successfully connected to the database!");
                return con;
            } catch (ClassNotFoundException e) {
                OCDConsole.printlnError("Where is your Oracle JDBC Driver?");
            } catch (SQLException e) {
                OCDConsole.printlnError("Connection to database failed: " + e.getMessage());
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
            OCDConsole.printlnError("Error closing the connection: " + e.getMessage());
        }
    }

    public static void closeStatement(Statement stm) {
        try {
            if(stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            OCDConsole.printlnError("Error closing statement");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            OCDConsole.printlnError("Error closing resultSet");
        }
    }
}
