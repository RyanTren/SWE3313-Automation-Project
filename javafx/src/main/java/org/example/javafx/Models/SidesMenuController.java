package org.example.javafx.Models;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidesMenuController implements Initializable {
    @FXML
    private Button drinksCategoryButton;
    @FXML private Button entreesCategoryButton;
    @FXML private Button startersCategoryButton;
    @FXML private Button dessertsCategoryButton;
    @FXML private Button sidesCategoryButton;

    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button checkoutButton;

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

        //Checkout Button Logic
        checkoutButton.setOnAction(event -> {
            System.out.println("Getting Customer Receipt...");
            performCheckout();
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

    // Method to handle checkout action
    private void performCheckout(){
        //Perform checkout actions here
        System.out.println("Getting Customer Receipt...");

        //Navigate to OrderReceiptController/OrderReceipt.fxml
        Stage stage = (Stage) checkoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrderReceiptWindow();
    }

    // Method to navigate to a different FXML file
//    private void navigateToFXML(String fxmlFileName) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/EntreeMenu.fxml"));
//            fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void navigateToFXML(String fxmlFileName) {
        FXMLLoader fxmlLoader;

        // Add conditions based on the fxmlFileName parameter
        if (fxmlFileName.equals("StarterMenu.fxml")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/StarterMenu.fxml"));
        } else if (fxmlFileName.equals("EntreeMenu.fxml")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/EntreeMenu.fxml"));
        } else if (fxmlFileName.equals("DessertMenu.fxml")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/DessertMenu.fxml"));
        } else if (fxmlFileName.equals("SidesMenu.fxml")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Model/SidesMenu.fxml"));
        } else {
            // Default case or error handling
            throw new IllegalArgumentException("Invalid FXML file name: " + fxmlFileName);
        }
    }
}
