package game;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import game.view.controllers.*;
import sun.plugin.javascript.navig.Anchor;
import game.view.controllers.MainController;

public class Main extends Application {

    private MainController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        controller = new MainController(primaryStage);

        controller.initLayout();

        controller.showStartScreen();
    }

}
    /**
     * Returns the main stage.
     * @return
     */


