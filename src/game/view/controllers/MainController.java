package game.view.controllers;

import game.Main;
import game.dao.DAOFactory;
import game.dao.entities.*;
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

    public Lord currentLord;
    public Adventurer currentAdventurer;

    private DAOFactory daoFactory;
    private Stage primaryStage;
    public BorderPane Layout;

    private static LayoutController layoutController;

    public MainController(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Odd Console Dungeon");
        this.daoFactory = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
    }


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

            //Give Controller access to main
            layoutController = loader.getController();
            layoutController.setMainController(this);
            layoutController.setDAOFactory(daoFactory);
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

            //Give Controller access to main
            StartScreenController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
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

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
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

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
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

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
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

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
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

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showlootScreen() {
        try {
            // Load start screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/screens/LootScreen.fxml"));
            AnchorPane LootScreen = loader.load();

            // Set startScreen into the top of root layout.
            Layout.setTop(LootScreen);

            //Give Controller access to main
            SubController controller = loader.getController();
            controller.setMainController(this);
            controller.setDAOFactory(daoFactory);
            controller.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printLog(String msg) {
        if(layoutController != null) {
            layoutController.printError(msg);
        }
    }
}

