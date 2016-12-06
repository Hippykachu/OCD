package game.view.controllers;

import game.dao.entities.Entity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import game.dao.entities.Item;


import java.net.URL;
import java.util.ResourceBundle;

public class InventoryScreenController extends SubController implements Initializable{

    @FXML private Label inventoryLordName;
    @FXML private Label inventoryAdventurerName;
    @FXML private Label inventoryBalance;
    @FXML private AnchorPane equipmentTab;
    @FXML private AnchorPane inventoryTab;

    @FXML private ProgressBar inventoryAdventurerLife;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private void handleBackInventoryButton(ActionEvent actionEvent) {
        mainController.showIdleScreen();
    }

    @Override
    public void init() {
        inventoryLordName.setText("Lord == " + mainController.currentLord.getLogin());
        inventoryAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        inventoryAdventurerLife.setProgress(entity.getHealthProgress());
        inventoryBalance.setText(String.valueOf(entity.getMoney()) + "€");

        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        TableView<Item> equipmentTable = (TableView<Item>) equipmentTab.getChildren().get(0);
        loadTable(equipmentTable);
        equipmentTable.setItems(FXCollections.observableArrayList(daoFactory.getInventoryDAO().getEquipment(adventurerEntity)));

        TableView<Item> inventoryTable = (TableView<Item>) inventoryTab.getChildren().get(0);
        loadTable(inventoryTable);
        inventoryTable.setItems(FXCollections.observableArrayList(daoFactory.getInventoryDAO().getInventory(adventurerEntity)));
    }
}
