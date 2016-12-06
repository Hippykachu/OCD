package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import game.dao.entities.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DeathScreenController extends SubController implements Initializable{

    @FXML private Label adventurerDeath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleWastedButton(ActionEvent actionEvent) {
        mainController.printLog("You are back in the adventurer selection menu");
        mainController.showAdventurerScreen();
    }

    @Override
    public void init() {
        adventurerDeath.setText(mainController.currentAdventurer.getName() + " is DEEEAAAAD");
    }
}
