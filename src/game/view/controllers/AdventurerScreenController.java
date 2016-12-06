package game.view.controllers;

import game.dao.entities.Adventurer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdventurerScreenController extends SubController implements Initializable{

    @FXML private TextField createAdventurerName;
    @FXML private Label lordNameAdventurerScreen;
    @FXML private ComboBox<Adventurer> adventurerList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleCreateAdventurer(ActionEvent actionEvent) {
        Adventurer adventurer = daoFactory.getAdventurerDAO().createAdventurer(mainController.currentLord, createAdventurerName.getText());
        if(adventurer != null){
            mainController.printLog("Adventurer Successfully created");
            adventurerList.getItems().add(0, adventurer);
        }
    }

    @FXML private void handleDisconnectButton(ActionEvent actionEvent) {
        mainController.currentLord = null;
        mainController.showStartScreen();
    }

    @Override
    public void init() {
        lordNameAdventurerScreen.setText(mainController.currentLord.getLogin());
        adventurerList.setItems(FXCollections.observableArrayList(daoFactory.getAdventurerDAO().getAdventurersOfLord(mainController.currentLord)));
        adventurerList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                mainController.currentAdventurer = newValue;
                mainController.showIdleScreen();
            }
        });
    }
}

