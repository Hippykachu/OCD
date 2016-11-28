package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("AdventurerScreen.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("IdleScreen.fxml"));
        Parent root4 = FXMLLoader.load(getClass().getResource("DeathScreen.fxml"));
        Parent root5 = FXMLLoader.load(getClass().getResource("InventoryScreen.fxml"));
        Parent root6 = FXMLLoader.load(getClass().getResource("ShopScreen.fxml"));


        initRootLayout();

        showPersonOverview();
        AnchorPane rootLayout;

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        /**
         * Initializes the root layout.
         */
        public void initRootLayout(){
            try {
                // Load root layout from fxml file.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
                rootLayout = (AnchorPane) loader.load();

                // Show the scene containing the root layout.
                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Shows the person overview inside the root layout.
         */
        public void showPersonOverview() {
            try {
                // Load person overview.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                rootLayout.setCenter(personOverview);
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


    public static void main(String[] args) {
        launch(args);
    }
}
