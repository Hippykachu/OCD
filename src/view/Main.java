package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


7
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initLayout();

        showStartScreen();
    }

        /**
         * Initializes the layout.
         */
        public void initLayout(){
            try {
               // Load layout from fxml file.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("view/screens/Layout.fxml"));
                layout = (BorderPane) loader.load();

                // Show the scene containing the layout.
                Scene scene = new Scene(layout);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Shows the person overview inside the root layout.
         */
        public void showStartScreen() {
            try {
                // Load start screen.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("view/screens/StartScreen.fxml"));
                AnchorPane startScreen = (AnchorPane) loader.load();

                // Set startScreen into the top of root layout.
                layout.setTop(startScreen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Returns the main stage.
         * @return
         */

        public Stage getPrimaryStage() {
            return primaryStage;
        }

        public static void main(String[] args) {
            launch(args);
        }

    }
