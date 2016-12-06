package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class IdleScreenController extends SubController implements Initializable{

    @FXML private Label idleLordName;
    @FXML private Label idleAdventurerName;
    @FXML private Label adventurerLevel;
    @FXML private Label adventurerDefence;
    @FXML private Label adventurerAttack;
    @FXML private Label adventurerCritics;
    @FXML private Label adventurerHealth;

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
        updateStatus();
    }

    public void updateStatus(){
        double defense = 0;
        double attack = 0;
        double critics = 0;
        double health = 0;
        Entity adventurerEntity = daoFactory.getEntityDAO().find(mainController.currentAdventurer.getEntityID());
        List<Item> equipmentItems = daoFactory.getInventoryDAO().getEquipment(adventurerEntity);
        for(Item item:equipmentItems){
            health += item.getBonusHealth();
            defense += item.getBonusDefense();
            attack += item.getBonusAttack();
            critics += item.getBonusCritical();
        }

        adventurerHealth.setText("Health -> " + Math.round(100 + adventurerEntity.getRooms()) * ((health/100)+1));
        adventurerLevel.setText("Level -> " + Math.round(adventurerEntity.getRooms()));
        adventurerDefence.setText("Defence -> " + Math.round(adventurerEntity.getRooms() * ((defense/100)+1)));
        adventurerAttack.setText("Attack -> " + Math.round(adventurerEntity.getRooms() * ((attack/100)+1)));
        adventurerCritics.setText("Critics -> " + Math.round(adventurerEntity.getRooms() * ((critics/100)+1)));
    }
}
