package game;

import javafx.application.Application;
import javafx.stage.Stage;
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


