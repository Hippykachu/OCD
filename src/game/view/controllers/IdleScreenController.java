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

    @FXML private ProgressBar idleAdventurerLife;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}


    @FXML private void handleInventoryButton(ActionEvent actionEvent) {
        mainController.printLog("Moved into your adventurer inventory/equipment");
        mainController.showInventoryScreen();
    }

    @FXML private void handleShopButton(ActionEvent actionEvent) {
        mainController.printLog("Moved into your adventurer inventory/shop");
        mainController.showShopScreen();
    }

    @FXML private void handleFleeButton(ActionEvent actionEvent) {
         daoFactory.getAdventurerDAO().flee(mainController.currentAdventurer);
         mainController.printLog("You fled, your weakness knows no limit");
    }

    @FXML private void handleFightButton(ActionEvent actionEvent) {
        if(!daoFactory.getAdventurerDAO().nextFight(mainController.currentAdventurer))
        {
            mainController.showDeathScreen();
            mainController.printLog("Your adventurer is now dead");
        }
        else
        {
            mainController.showlootScreen();
            Monster monster = daoFactory.getMonsterDAO().getCurrentMonsterOfAdventurer(mainController.currentAdventurer);
            mainController.printLog("YOU DEFEATED --> " + monster.getMonsterName());
        }
    }

    @FXML private void handleSwitchAdventurerButton(ActionEvent actionEvent) {
        mainController.currentAdventurer = null;
        mainController.showAdventurerScreen();
        mainController.printLog("You are back in the adventurer selection menu");
    }

    @Override
    public void init() {
        idleLordName.setText("Lord == " + mainController.currentLord.getLogin());
        idleAdventurerName.setText("Adventurer == " + mainController.currentAdventurer.getName());
        Entity entity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        idleAdventurerLife.setProgress(entity.getHealthProgress());
    }
}
