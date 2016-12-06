package game.view.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.*;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by hugoc on 05/12/2016.
 */
public class LootScreenController extends SubController implements Initializable{

    @FXML private AnchorPane lootTab;
    @FXML private AnchorPane inventoryTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleCloseLootButton(ActionEvent actionEvent) {
        mainController.showIdleScreen();
    }


    @Override
    public void init() {
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        TableView<Item> lootTable = (TableView<Item>) lootTab.getChildren().get(0);
        loadTable(lootTable);
        lootTable.setItems(FXCollections.observableArrayList(daoFactory.getItemDAO().consultLoot(mainController.currentAdventurer)));

        TableView<Item> inventoryTable = (TableView<Item>) inventoryTab.getChildren().get(0);
        loadTable(inventoryTable);
        inventoryTable.setItems(FXCollections.observableArrayList(daoFactory.getInventoryDAO().getInventory(adventurerEntity)));
    }
}
