package game.dao;

import game.dao.interfaces.LordDAO;
import game.dao.interfaces.AdventurerDAO;
import game.dao.interfaces.EntityDAO;
import game.dao.interfaces.MonsterDAO;
import game.dao.interfaces.InventoryDAO;
import game.dao.interfaces.ItemDAO;
import game.dao.oracle.OracleDAOFactory;

/**
 * Created by t00191729 on 24/11/2016.
 */

public abstract class DAOFactory {
    public static final int ORACLE = 1;

    public abstract LordDAO getLordDAO();
    public abstract ItemDAO getItemDAO();
    public abstract EntityDAO getEntityDAO();
    public abstract AdventurerDAO getAdventurerDAO();
    public abstract InventoryDAO getInventoryDAO();
    public abstract MonsterDAO getMonsterDAO();


    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case ORACLE:
                return new OracleDAOFactory();
            default:
                return null;
        }
    }
}
