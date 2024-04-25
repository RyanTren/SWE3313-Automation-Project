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
package org.example.javafx.Models.WaiterModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

//import javax.swing.text.html.ImageView;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.HashMap;
import java.util.Map;

public class DrinksMenuController implements Initializable {
    @FXML private Button drinksCategoryButton;
    @FXML private Button entreesCategoryButton;
    @FXML private Button startersCategoryButton;
    @FXML private Button dessertsCategoryButton;
    @FXML private Button sidesCategoryButton;

    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button checkoutButton;

    @FXML private Button drinkOne;
    @FXML private Button drinkTwo;
    @FXML private Button drinkThree;
    @FXML private Button drinkFour;

    @FXML private ImageView waterImage;
    @FXML private ImageView sodaImage;
    @FXML private ImageView ipaImage;
    @FXML private ImageView sweetTeaImage;

    @FXML private ImageView itemImageInsert;

    // Define a map to store items and their quantities
    private Map<javafx.scene.image.Image, Integer> cartItems = new HashMap<>();

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



        /*What I'm trying to do here is that, if the user click the Water button
         *it will get added to the Order cart. If someone can fix the image transfer them please..
         * please help me ;(
         */

        // Drink Button Logic
        drinkOne.setOnAction(event -> {
            addItemToCart(waterImage.getImage());
        });

        drinkTwo.setOnAction(event -> {
            addItemToCart(sodaImage.getImage());
        });

        drinkThree.setOnAction(event -> {
            addItemToCart(ipaImage.getImage());
        });

        drinkFour.setOnAction(event -> {
            addItemToCart(sweetTeaImage.getImage());
        });



        //Checkout Button Logic
        checkoutButton.setOnAction(event -> {
            System.out.println("Getting Customer Receipt...");
            performCheckout();
        });

//        // Drinks Category Button Logic
//        drinksCategoryButton.setOnAction(event -> {
//            System.out.println("Navigating to Drinks Category");
//            Stage stage = (Stage) drinksCategoryButton.getScene().getWindow();
//            Model.getInstance().getViewFactory().closeStage(stage);
//            Model.getInstance().getViewFactory().showDrinksMenu();
//        });

        // Entrees Category Button Logic
        entreesCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Entrees Category");
            Stage stage = (Stage) entreesCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showEntreesMenu();
        });

        // Starter Category Button Logic
        startersCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Starter Category");
            Stage stage = (Stage) startersCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showStartersMenu();
        });

        // Desserts Category Button Logic
        dessertsCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Desserts Category");
            Stage stage = (Stage) dessertsCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showDessertsMenu();
        });

        // Sides Category Button Logic
        sidesCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Sides Category");
            Stage stage = (Stage) sidesCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showSidesMenu();
        });
    }

    // Method to handle logout action
    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    // Method to handle back action
    private void performBack() {
        // Perform back actions here
        System.out.println("User went back a screen.");

        // You may navigate to the previous screen
        Stage stage = (Stage) backButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showTableWindow();
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

    //This works.... kinda
    private void addItemToCart(javafx.scene.image.Image image) {
        // Add item to order cart
        System.out.println("Adding item to order cart...");

        // Transfer image to display
        itemImageInsert.setImage(image);
    }


//    private void addItemToCart(javafx.scene.image.Image image) {
//        // Check if the item is already in the cart
//        if (cartItems.containsKey(image)) {
//            // If yes, increment the quantity
//            int quantity = cartItems.get(image);
//            cartItems.put(image, quantity + 1);
//        } else {
//            // If not, add it to the cart with quantity 1
//            cartItems.put(image, 1);
//        }
//
//        // Update the display with the latest cart content (you need to implement this part)
//        updateCartDisplay();
//    }

    // Method to update the display with the latest cart content
    private void updateCartDisplay() {
        // You need to implement this method to update the display with the latest cart content
        // This might involve updating a UI component with the cart items and quantities
        // For example, you could update a TableView, a ListView, or any other UI component to display the cart content
    }

}

