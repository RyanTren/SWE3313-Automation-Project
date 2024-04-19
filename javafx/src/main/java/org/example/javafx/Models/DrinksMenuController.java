//package org.example.javafx.Models;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ToggleButton;
//import javafx.stage.Stage;
//import org.example.javafx.Models.Model;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class DrinksMenuController implements Initializable {
//    @FXML private Button drinksCategoryButton;
//    @FXML private Button entreesCategoryButton;
//    @FXML private Button startersCategoryButton;
//    @FXML private Button desertsCategoryButton;
//    @FXML private Button sidesCategoryButton;
//
//    @FXML private Button logoutButton;
//    @FXML private Button backButton;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        // Logout Button Logic
//        logoutButton.setOnAction(event -> {
//            System.out.println("Logging out!");
//            performLogout();
//        });
//
//        // Back Button Logic
//        backButton.setOnAction(event -> {
//            System.out.println("User went back a screen.");
//            performBack();
//        });
//    }
//
//    // Method to handle logout action
//    private void performLogout() {
//        // Perform logout actions here
//        System.out.println("User logged out.");
//
//        // You may navigate to the login screen
//        Stage stage = (Stage) logoutButton.getScene().getWindow();
//        Model.getInstance().getViewFactory().closeStage(stage);
//    }
//
//    // Method to handle back action
//    private void performBack() {
//        // Perform back actions here
//        System.out.println("User went back a screen.");
//
//        // You may navigate to the previous screen
//        Stage stage = (Stage) backButton.getScene().getWindow();
//        Model.getInstance().getViewFactory().closeStage(stage);
//        Model.getInstance().getViewFactory().showWaiterTableWindow();
//    }
//
//}
package org.example.javafx.Models;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrinksMenuController implements Initializable {
    @FXML private Button drinksCategoryButton;
    @FXML private Button entreesCategoryButton;
    @FXML private Button startersCategoryButton;
    @FXML private Button dessertsCategoryButton;
    @FXML private Button sidesCategoryButton;

    @FXML private Button logoutButton;
    @FXML private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Logout Button Logic
        logoutButton.setOnAction(event -> {
            System.out.println("Logging out!");
            performLogout();
        });

        // Back Button Logic
        backButton.setOnAction(event -> {
            System.out.println("User went back a screen.");
            performBack();
        });

        // Drinks Category Button Logic
        drinksCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Drinks Category");
            navigateToFXML("DrinksMenu.fxml");
        });

        // Entrees Category Button Logic
        entreesCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Entrees Category");
            navigateToFXML("EntreesMenu.fxml");
        });

        // Starters Category Button Logic
        startersCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Starters Category");
            navigateToFXML("StartersMenu.fxml");
        });

        // Desserts Category Button Logic
        dessertsCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Desserts Category");
            navigateToFXML("DessertsMenu.fxml");
        });

        // Sides Category Button Logic
        sidesCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Sides Category");
            navigateToFXML("SidesMenu.fxml");
        });
    }

    // Method to handle logout action
    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    // Method to handle back action
    private void performBack() {
        // Perform back actions here
        System.out.println("User went back a screen.");

        // You may navigate to the previous screen
        Stage stage = (Stage) backButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showWaiterTableWindow();
    }

    // Method to navigate to a different FXML file
    private void navigateToFXML(String fxmlFileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/EntreeMenu.fxml"));
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

