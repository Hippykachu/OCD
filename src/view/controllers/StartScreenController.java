package view.controllers;

import dao.DAOFactory;
import dao.interfaces.LordDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable{

    private DAOFactory daoFactory;

    public StartScreenController(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @FXML private TextField createLordLogin;
    @FXML private TextField createLordPassword;
    @FXML private TextField createLordPassword2;

    @FXML private TextField connectLordLogin;
    @FXML private TextField connectLordPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleCreateLord(ActionEvent actionEvent) {
        daoFactory.getLordDAO().createLord(createLordLogin.getText(), createLordPassword.getText(), createLordPassword2.getText());
    }

    @FXML private void handleLoginLord(ActionEvent actionEvent) {
        daoFactory.getLordDAO().connectUser(connectLordLogin.getText(), connectLordPassword.getText());
    }
}
