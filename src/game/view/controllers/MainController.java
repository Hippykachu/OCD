package game.view.controllers;

import game.Main;
import game.dao.entities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by hugoc on 04/12/2016.
 */

public class MainController {

    @FXML
    private StartScreenController startScreenController;
    @FXML
    private AdventurerScreenController adventurerScreenController;
    @FXML
    private LayoutController layoutController;
    @FXML
    private IdleScreenController idleScreenController;
    @FXML
    private InventoryScreenController inventoryScreenController;
    @FXML
    private ShopScreenController shopScreenController;
    @FXML
    private DeathScreenController deathScreenController;

    public Lord currentLord;
    public Adventurer currentAdventurer;

    public Stage primaryStage;
    public BorderPane Layout;

    /*
     * Initializes the layout.
     */
    public void initLayout() {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/Layout.fxml"));
            Layout = loader.load();

            // Show the scene containing the layout.
            Scene scene = new Scene(Layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Creation of the show screen methods
     */
    public void showStartScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/StartScreen.fxml"));
            AnchorPane StartScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(StartScreen);

           /*Give Controller access to main
            StartScreenController controller = loader.getController();
            controller.setMain(this);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAdventurerScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/AdventurerScreen.fxml"));
            AnchorPane AdventurerScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(AdventurerScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showIdleScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/IdleScreen.fxml"));
            AnchorPane IdleScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(IdleScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showInventoryScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/InventoryScreen.fxml"));
            AnchorPane InventoryScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(InventoryScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showShopScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/ShopScreen.fxml"));
            AnchorPane ShopScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(ShopScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDeathScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/DeathScreen.fxml"));
            AnchorPane DeathScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(DeathScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Switch between the different screens
     */
    public void switchScreenToAdventurer() {
        if (StartScreenController.handleLoginLord() = true)
            showAdventurerScreen();
    }


}

