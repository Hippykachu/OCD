package game.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import game.dao.entities.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController extends SubController implements Initializable{

    @FXML private TextField createLordLogin;
    @FXML private PasswordField createLordPassword1;
    @FXML private PasswordField createLordPassword2;

    @FXML private TextField connectLordLogin;
    @FXML private PasswordField connectLordPassword;

    //DAO Connexion
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    //Constructor
    @FXML private void handleCreateLord(ActionEvent actionEvent) {
        if(daoFactory.getLordDAO().createLord(createLordLogin.getText(), createLordPassword1.getText(), createLordPassword2.getText())){
            mainController.printLog("Lord successfully created");
        }
        else{
            mainController.printLog("Invalid creation inputs");
        }
    }

    @FXML public void handleLoginLord(ActionEvent actionEvent) {
        Lord lord = daoFactory.getLordDAO().connectUser(connectLordLogin.getText(), connectLordPassword.getText());
        if(lord != null) {
            mainController.currentLord = lord;
            mainController.showAdventurerScreen();
            mainController.printLog("Lord successfully connected");
        }
        else{
            mainController.printLog("Invalid login inputs");
        }
    }

    @Override
    public void init() {

    }
}
