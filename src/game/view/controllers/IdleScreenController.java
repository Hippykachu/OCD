package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.*;

import java.net.URL;
import java.util.ResourceBundle;

public class IdleScreenController extends SubController implements Initializable{

    @FXML private Label idleLordName;
    @FXML private Label idleAdventurerName;
    @FXML private Label fightResultLabel;

    @FXML private ProgressBar idleAdventurerLife;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}


    @FXML private void handleInventoryButton(ActionEvent actionEvent) {
        mainController.showInventoryScreen();
    }

    @FXML private void handleShopButton(ActionEvent actionEvent) {
        mainController.showShopScreen();
    }

    @FXML private void handleFleeButton(ActionEvent actionEvent) {
         daoFactory.getAdventurerDAO().flee(mainController.currentAdventurer);
    }

    @FXML private void handleFightButton(ActionEvent actionEvent) {
        if(!daoFactory.getAdventurerDAO().nextFight(mainController.currentAdventurer))
        {
            mainController.showDeathScreen();
        }
    }

    @FXML private void handleSwitchAdventurerButton(ActionEvent actionEvent) {
        mainController.currentAdventurer = null;
        mainController.showAdventurerScreen();
    }

    @Override
    public void init() {
        idleLordName.setText(mainController.currentLord.getLogin());
        idleAdventurerName.setText(mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        idleAdventurerLife.setProgress(entity.getHealthProgress());
    }
}
