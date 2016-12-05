package game.view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by t00191729 on 30/11/2016.
 */



public class LayoutController {

    @FXML static Label errorLogLayout;

    @FXML public static void printError(String msg) {
        errorLogLayout.setText(msg);
    }
}
