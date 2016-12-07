package game.view.controllers;

import game.dao.entities.Item;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import game.dao.entities.Entity;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopScreenController extends SubController implements Initializable {

    String soundFile = "src/resources/pock.mp3";

    @FXML
    private Label shopLordName;
    @FXML
    private Label shopAdventurerName;
    @FXML
    private Label shopBalance;

    @FXML
    private ProgressBar shopAdventurerLife;

    @FXML
    private AnchorPane shopTab;
    @FXML
    private AnchorPane inventoryTab;

    private List<Item> inventoryItems;
    private List<Item> shopItems;

    private TableView<Item> shopTable;
    private TableView<Item> inventoryTable;

    private Entity adventurerEntity;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleBackShopButton(ActionEvent actionEvent) {
        mainController.printLog("You moved back in the dungeon");
        mainController.showIdleScreen();
    }


    @Override
    public void init() {
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        shopLordName.setText("Lord == " + mainController.currentLord.getLogin());
        shopAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());

        updateAdventurer();

        shopTable = (TableView<Item>) shopTab.getChildren().get(0);
        loadTable(shopTable);
        shopItems = daoFactory.getItemDAO().consultShop(mainController.currentAdventurer);
        shopTable.setItems(FXCollections.observableArrayList());
        shopTable.setRowFactory(tv -> {
            TableRow<Item> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && !tableRow.isEmpty()) {
                    Item item = tableRow.getItem();
                    buyItem(item);
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
                    sellItem(item);
                }
            });
            return tableRow;
        });

        updateTables();
    }

    private void updateAdventurer() {
        adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        shopAdventurerLife.setProgress(adventurerEntity.getHealthProgress());
        shopBalance.setText(String.valueOf(adventurerEntity.getMoney()) + "€");
    }

    private void updateTables() {
        shopTable.setItems(FXCollections.observableArrayList(shopItems));
        inventoryTable.setItems(FXCollections.observableArrayList(inventoryItems));
        updateAdventurer();
    }

    private void buyItem(Item item) {
        if(daoFactory.getAdventurerDAO().buyItem(mainController.currentAdventurer, item.getItemID())){
            shopItems.remove(item);
            inventoryItems.add(item);
            updateTables();
            mainController.printLog("Item has been purchased");
        }
        else
            mainController.printLog("You can't do that");
    }

    private void sellItem(Item item) {
        if(daoFactory.getAdventurerDAO().sellItem(mainController.currentAdventurer, item.getItemID())){
            inventoryItems.remove(item);
            updateTables();
            mainController.printLog("Item has been sold");
        }
        else
            mainController.printLog("You can't do that");
    }
}
