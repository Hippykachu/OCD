package game.view.controllers;

import game.dao.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import game.Main;
import game.dao.entities.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController extends SubController implements Initializable{

    @FXML private TextField createLordLogin;
    @FXML private PasswordField createLordPassword1;
    @FXML private PasswordField createLordPassword2;

    @FXML private TextField connectLordLogin;
    @FXML private PasswordField connectLordPassword;

    //Reference to the main
    private Main main;

    //DAO Connexion
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //Constructor
    @FXML private void handleCreateLord(ActionEvent actionEvent) {
        daoFactory.getLordDAO().createLord(createLordLogin.getText(), createLordPassword1.getText(), createLordPassword2.getText());
    }

    @FXML public void handleLoginLord(ActionEvent actionEvent) {
        Lord lord = daoFactory.getLordDAO().connectUser(connectLordLogin.getText(), connectLordPassword.getText());
        if(lord != null) {
            mainController.currentLord = lord;
            mainController.showAdventurerScreen();
        }
        //mainController.showAdventurerScreen();
    }

    public static boolean handleLoginLord() {
        return handleLoginLord();
    }
}
