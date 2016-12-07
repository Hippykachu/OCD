package game.view.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import game.dao.entities.*;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by hugoc on 05/12/2016.
 */
public class LootScreenController extends SubController implements Initializable{

    String soundFile = "src/resources/pock.mp3";

    @FXML private AnchorPane lootTab;
    @FXML private AnchorPane inventoryTab;

    private List<Item> inventoryItems;
    private List<Item> lootItems;

    private TableView<Item> lootTable;
    private TableView<Item> inventoryTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleCloseLootButton(ActionEvent actionEvent) {
        mainController.printLog("Ready for the next fight");
        mainController.showIdleScreen();
    }




    @Override
    public void init() {
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        lootTable = (TableView<Item>) lootTab.getChildren().get(0);
        loadTable(lootTable);
        lootItems = daoFactory.getItemDAO().consultLoot(mainController.currentAdventurer);
        lootTable.setRowFactory(tv -> {
            TableRow<Item> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && !tableRow.isEmpty()) {
                    Item item = tableRow.getItem();
                    takeItemFromMonster(item);
                }
            });
            return tableRow;
        });

        inventoryTable = (TableView<Item>) inventoryTab.getChildren().get(0);
        loadTable(inventoryTable);
        inventoryItems = daoFactory.getInventoryDAO().getInventory(adventurerEntity);

        updateTables();
    }

    private void updateTables() {
        lootTable.setItems(FXCollections.observableArrayList(lootItems));
        inventoryTable.setItems(FXCollections.observableArrayList(inventoryItems));
    }

    private void takeItemFromMonster(Item item) {
        Monster monster = daoFactory.getMonsterDAO().getCurrentMonsterOfAdventurer(mainController.currentAdventurer);
        Entity monsterEntity = daoFactory.getEntityDAO().find(monster.getEntityID());
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        if(daoFactory.getInventoryDAO().moveItem(monsterEntity.getEquipmentId(),adventurerEntity.getInventoryId(), item.getItemID())){
            lootItems.remove(item);
            inventoryItems.add(item);
            updateTables();
            mainController.printLog("Item has been looted");
        }
        else
            mainController.printLog("You can't do that");
    }
}
