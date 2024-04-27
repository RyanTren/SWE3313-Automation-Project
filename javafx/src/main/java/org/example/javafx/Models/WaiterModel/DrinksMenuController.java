package org.example.javafx.Models.WaiterModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.database.JSTable;
import org.example.javafx.Models.Model;

//import javax.swing.text.html.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class DrinksMenuController implements Initializable {
    @FXML
    private Button drinksCategoryButton;
    @FXML
    private Button entreesCategoryButton;
    @FXML
    private Button startersCategoryButton;
    @FXML
    private Button dessertsCategoryButton;
    @FXML
    private Button sidesCategoryButton;

    @FXML
    private Button logoutButton;
    @FXML
    private Button backButton;
    @FXML
    private Button checkoutButton;

    @FXML
    private Button drinkOne;
    @FXML
    private Button drinkTwo;
    @FXML
    private Button drinkThree;
    @FXML
    private Button drinkFour;

    @FXML
    private ImageView waterImage;
    @FXML
    private ImageView sodaImage;
    @FXML
    private ImageView ipaImage;
    @FXML
    private ImageView sweetTeaImage;

    @FXML
    private VBox cartContainer;
    @FXML
    private ImageView itemImageInsert;
    @FXML
    private Button addQuantityButton;
    @FXML
    private Button subtractQuantityButton;
    private int itemQuantity = -1; // Initial quantity
    private int quantity = 0; //integer for amount of vbox's


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

//        // Add Quantity Button Logic
//        addQuantityButton.setOnAction(event -> {
//            quantity++;
//            updateQuantityLabel();
//        });
//
//        // Subtract Quantity Button Logic
//        subtractQuantityButton.setOnAction(event -> {
//            if (quantity > 0) {
//                quantity--;
//                updateQuantityLabel();
//            }
//        });

        // Add Quantity Button Logic
        addQuantityButton.setOnAction(event -> {
            itemQuantity++;
            updateQuantityLabel();
        });

        // Subtract Quantity Button Logic
        subtractQuantityButton.setOnAction(event -> {
            if (itemQuantity > 0) {
                itemQuantity--;
                updateQuantityLabel();
            }
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

    @FXML
    private void handleItemClick(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        Image image = imageView.getImage();
        addItemToCart(image);
    }


//    //This works.... but you have to click the button region not the picture or the text
//    private void addItemToCart(javafx.scene.image.Image image) {
//        // Add item to order cart
//        System.out.println("Adding item to order cart...");
//
//        // Transfer image to display
//        itemImageInsert.setImage(image);
//    }

    private Group createItemGroup(Image image) {
        // Create UI elements for the item
        ImageView itemImageView = new ImageView(image);
        itemImageView.setFitWidth(139);
        itemImageView.setFitHeight(104);

        // Create buttons for quantity control
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");

        // Add event handlers for quantity buttons
        addButton.setOnAction(event -> {
            itemQuantity++;
            updateQuantityLabel();
        });
        subtractButton.setOnAction(event -> {
            if (itemQuantity > 0) {
                itemQuantity--;
                updateQuantityLabel();
            }
        });

        // Create a Group to hold all UI elements
        Group group = new Group();
        group.getChildren().addAll(itemImageView, addButton, subtractButton);

        return group;
    }

    private void addItemToCart(Image image) {

//            itemImageInsert.setImage(image);

        // Check if the number of children in cartContainer is less than 4
        if (cartContainer.getChildren().size() < 4) {
            // Create a Group for the item container
            Group group = new Group();

            itemImageInsert.setImage(image);

            // Create a Rectangle to serve as the background
            Rectangle backgroundRect = new Rectangle(236, 131);
            backgroundRect.setFill(Color.web("#d9d9d9"));
            backgroundRect.setArcWidth(20);
            backgroundRect.setArcHeight(20);

            // Create Add and Subtract Buttons
            Button addButton = new Button("+");
            addButton.setLayoutX(187);
            addButton.setLayoutY(17);
            addButton.setPrefWidth(39.0);
            addButton.setPrefHeight(40.0);
            addButton.setStyle("-fx-background-color: #3BB138; -fx-background-radius: 25;");
            addButton.setFont(Font.font(19));
            addButton.setTextFill(Color.WHITE);

            addButton.setOnAction(event -> {
                itemQuantity++;
                updateQuantityLabel();
            });

            Button subtractButton = new Button("-");
            subtractButton.setLayoutX(187);
            subtractButton.setLayoutY(73);
            subtractButton.setPrefWidth(39.0);
            subtractButton.setPrefHeight(40.0);
            subtractButton.setStyle("-fx-background-color: #D2C01D; -fx-background-radius: 25;");
            subtractButton.setFont(Font.font(19));
            subtractButton.setTextFill(Color.WHITE);

            subtractButton.setOnAction(event -> {
                if (itemQuantity > 0) {
                    itemQuantity--;
                    updateQuantityLabel();
                }
            });

            // Create ImageView for the item
            ImageView itemImageView = new ImageView(image);
            itemImageView.setLayoutX(23);
            itemImageView.setLayoutY(14);
            itemImageView.setFitWidth(139);
            itemImageView.setFitHeight(104); // Added fitHeight
            itemImageView.setPreserveRatio(true); // Added to preserve aspect ratio

            // Add all elements to the Group
            group.getChildren().addAll(backgroundRect, addButton, subtractButton, itemImageView);

            // Add the Group to the cart container
            cartContainer.getChildren().add(group);
        } else {
            // Notify the user that the maximum limit has been reached
            System.out.println("Maximum limit reached. You can only add up to 4 different drinks to the cart.");
        }
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

    // Method to update the quantity label
    private void updateQuantityLabel() {
        // Update UI to display the current quantity
        System.out.println(STR."Different Drink Quantity: \{quantity}"); // For testing, you can replace this with actual UI update code
    }


    // Method to handle checkout action
    private void performCheckout() {
        //Perform checkout actions here
        System.out.println(STR."Getting Customer Receipt for Table \{Model.getInstance().getCurrentTableID()}");
        JSTable jt = JSTable.get(Model.getInstance().getCurrentTableID());
        if (jt != null) {
            jt.status = JSTable.TABLE_STATUS.FINISHED.name();
            jt.clean = false;
            jt.save();
        }
        //Navigate to OrderReceiptController/OrderReceipt.fxml
        Stage stage = (Stage) checkoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrderReceiptWindow();
    }
}
