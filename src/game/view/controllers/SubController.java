package game.view.controllers;

import game.dao.DAOFactory;
import game.dao.entities.Item;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    protected void loadTable(TableView<Item> table){
        ((TableColumn<Item, String>) table.getColumns().get(0)).setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        ((TableColumn<Item, String>) table.getColumns().get(1)).setCellValueFactory(cellData -> cellData.getValue().typeNameProperty());
        ((TableColumn<Item, Integer>) table.getColumns().get(2)).setCellValueFactory(cellData -> cellData.getValue().bonusHealthProperty().asObject());
        ((TableColumn<Item, Integer>) table.getColumns().get(3)).setCellValueFactory(cellData -> cellData.getValue().bonusDefenseProperty().asObject());
        ((TableColumn<Item, Integer>) table.getColumns().get(4)).setCellValueFactory(cellData -> cellData.getValue().bonusAttackProperty().asObject());
        ((TableColumn<Item, Integer>) table.getColumns().get(5)).setCellValueFactory(cellData -> cellData.getValue().bonusCriticalProperty().asObject());
        ((TableColumn<Item, Double>) table.getColumns().get(6)).setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    }
}
