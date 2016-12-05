package game.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by t00191729 on 30/11/2016.
 */



public class LayoutController extends SubController implements Initializable{

    @FXML private Label ErrorLogLayout;

    @FXML public void printError(String msg) {
        ErrorLogLayout.setText(msg);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void init() {

    }
}
