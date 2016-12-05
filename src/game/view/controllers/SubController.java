package game.view.controllers;

import game.dao.DAOFactory;

/**
 * Created by t00191729 on 05/12/2016.
 */

public abstract class SubController {

    protected MainController mainController;
    protected DAOFactory daoFactory;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public void setDAOFactory(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public abstract void init();
}
