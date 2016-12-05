package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeathScreenController extends SubController implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleWastedButton(ActionEvent actionEvent) {
        mainController.showAdventurerScreen();
    }

    @Override
    public void init() {

    }
}
