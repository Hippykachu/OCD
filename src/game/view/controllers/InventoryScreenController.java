package game.view.controllers;

import game.dao.entities.Entity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


import java.net.URL;
import java.util.ResourceBundle;

public class InventoryScreenController extends SubController implements Initializable{

    @FXML private Label inventoryLordName;
    @FXML private Label inventoryAdventurerName;
    @FXML private Label inventoryBalance;

    @FXML private ProgressBar inventoryAdventurerLife;
    //@FXML private TableView equipmentTable;
    //@FXML private TableView inventoryTable;

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
    }
}
