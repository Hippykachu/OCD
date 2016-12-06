package game.view.controllers;

import game.dao.entities.Item;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.Entity;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopScreenController extends SubController implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleBackShopButton(ActionEvent actionEvent) {
        mainController.showIdleScreen();
    }


    @Override
    public void init() {
        shopLordName.setText("Lord == " + mainController.currentLord.getLogin());
        shopAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        shopAdventurerLife.setProgress(entity.getHealthProgress());
        shopBalance.setText(String.valueOf(entity.getMoney()) + "€");


        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        TableView<Item> shopTable = (TableView<Item>) shopTab.getChildren().get(0);
        loadTable(shopTable);
        shopTable.setItems(FXCollections.observableArrayList(daoFactory.getItemDAO().consultShop(mainController.currentAdventurer)));

        TableView<Item> inventoryTable = (TableView<Item>) inventoryTab.getChildren().get(0);
        loadTable(inventoryTable);
        inventoryTable.setItems(FXCollections.observableArrayList(daoFactory.getInventoryDAO().getInventory(adventurerEntity)));
    }
}
