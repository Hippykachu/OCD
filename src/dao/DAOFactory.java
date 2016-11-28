package dao;


import dao.interfaces.LordDAO;
import dao.oracle.OracleDAOFactory;

/**
 * Created by t00191729 on 24/11/2016.
 */

public abstract class DAOFactory {
    public static final int ORACLE = 1;

    public abstract LordDAO getLordDAO();


    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case ORACLE:
                return new OracleDAOFactory();
            default:
                return null;
        }
    }
}
