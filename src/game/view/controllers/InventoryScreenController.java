package game.view.controllers;

import game.dao.entities.Entity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import game.dao.entities.Item;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InventoryScreenController extends SubController implements Initializable{

    String soundFile = "src/resources/pock.mp3";

    @FXML private Label inventoryLordName;
    @FXML private Label inventoryAdventurerName;
    @FXML private Label inventoryBalance;
    @FXML private AnchorPane equipmentTab;
    @FXML private AnchorPane inventoryTab;

    @FXML private ProgressBar inventoryAdventurerLife;

    private List<Item> inventoryItems;
    private List<Item> equipmentItems;

    private TableView<Item> equipmentTable;
    private TableView<Item> inventoryTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private void handleBackInventoryButton(ActionEvent actionEvent) {
        mainController.printLog("You moved back in the dungeon");
        mainController.showIdleScreen();
    }

    @Override
    public void init() {
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        inventoryLordName.setText("Lord == " + mainController.currentLord.getLogin());
        inventoryAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        inventoryAdventurerLife.setProgress(entity.getHealthProgress());
        inventoryBalance.setText(String.valueOf(entity.getMoney()) + "€");

        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        equipmentTable = (TableView<Item>) equipmentTab.getChildren().get(0);
        loadTable(equipmentTable);
        equipmentItems = daoFactory.getInventoryDAO().getEquipment(adventurerEntity);
        equipmentTable.setRowFactory(tv -> {
            TableRow<Item> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && !tableRow.isEmpty()) {
                    Item item = tableRow.getItem();
                    unequipItem(item);
                }
            });
            return tableRow;
        });

        inventoryTable = (TableView<Item>) inventoryTab.getChildren().get(0);
        loadTable(inventoryTable);
        inventoryItems = daoFactory.getInventoryDAO().getInventory(adventurerEntity);
        inventoryTable.setRowFactory(tv -> {
            TableRow<Item> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && !tableRow.isEmpty()) {
                    Item item = tableRow.getItem();
                    equipItem(item);
                }
            });
            return tableRow;
        });

        updateTables();
    }


    private void updateTables() {
        equipmentTable.setItems(FXCollections.observableArrayList(equipmentItems));
        inventoryTable.setItems(FXCollections.observableArrayList(inventoryItems));
    }

    private void unequipItem(Item item) {
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        if(daoFactory.getInventoryDAO().unequipItem(adventurerEntity, item.getItemID())){
            equipmentItems.remove(item);
            inventoryItems.add(item);
            updateTables();
            mainController.printLog("Item has been unequipped");
        }
        else
            mainController.printLog("You can't do that");
    }

    private void equipItem(Item item) {
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        if(daoFactory.getInventoryDAO().equipItem(adventurerEntity, item.getItemID())){
            inventoryItems.remove(item);
            equipmentItems.add(item);
            updateTables();
            mainController.printLog("Item has been equipped");
        }
        else
            mainController.printLog("You can't do that");
    }
}
