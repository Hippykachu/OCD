package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.Entity;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopScreenController extends SubController implements Initializable{

    @FXML private Label shopLordName;
    @FXML private Label shopAdventurerName;
    @FXML private Label shopBalance;

    @FXML private ProgressBar shopAdventurerLife;
    //@FXML private TableView equipmentTable;
    //@FXML private TableView inventoryTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleBackShopButton(ActionEvent actionEvent) {
        mainController.showIdleScreen();
    }


    @Override
    public void init() {
        shopLordName.setText("Lord == " + mainController.currentLord.getLogin());
        shopAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        shopAdventurerLife.setProgress(entity.getHealthProgress());
        shopBalance.setText(String.valueOf(entity.getMoney()) + "€");
    }
}
