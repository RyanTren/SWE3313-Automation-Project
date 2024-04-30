package org.example.javafx.Models.WaiterModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.example.database.JSTable;
import org.example.database.Transaction;
import org.example.javafx.Models.Model;
import org.example.javafx.Models.OrderJSONObject;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class DesertsMenuController implements Initializable {
    @FXML
    private Button drinksCategoryButton;
    @FXML private Button entreesCategoryButton;
    @FXML private Button startersCategoryButton;
    @FXML private Button dessertsCategoryButton;
    @FXML private Button sidesCategoryButton;

    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button checkoutButton;

    @FXML
    private Button dessertOne;
    @FXML
    private Button dessertTwo;
    @FXML
    private Button dessertThree;
    @FXML
    private Button dessertFour;

    @FXML
    private VBox cartContainer;
    @FXML
    private Text subtotalValueLabel, taxValueLabel, totalValueLabel;

    public static final float TAX_RATE = 0.1f; // 10% tax

    private enum MENU_ITEM {
        BANANA("Banana Pudding", "bananaImage", 6.00f),
        SILK("Chocolate French Silk", "chocolateImage", 8.00f),
        BREADPUDDING("Bread Pudding", "puddingImage", 6.50f),
        ICECREAM("Bacon Ice Cream", "icecreamImage", 4.50f);

        private final String name, id;
        private final float price;

        MENU_ITEM(String name, String id, float price) {
            this.name = name.toLowerCase();
            this.id = id;
            this.price = price;
        }

        String getName() {
            return this.name;
        }
    }

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

        // Dessert Button Logic
        dessertOne.setOnAction(this::handleItemClick);
        dessertTwo.setOnAction(this::handleItemClick);
        dessertThree.setOnAction(this::handleItemClick);
        dessertFour.setOnAction(this::handleItemClick);

        //Checkout Button Logic
        checkoutButton.setOnAction(event -> {
            System.out.println("Getting Customer Receipt...");
            performCheckout();
        });

        // Drinks Category Button Logic
        drinksCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Drinks Category");
            Stage stage = (Stage) drinksCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showDrinksMenu();
        });

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

//        // Desserts Category Button Logic
//        dessertsCategoryButton.setOnAction(event -> {
//            System.out.println("Navigating to Desserts Category");
//            Stage stage = (Stage) dessertsCategoryButton.getScene().getWindow();
//            Model.getInstance().getViewFactory().closeStage(stage);
//            Model.getInstance().getViewFactory().showDessertsMenu();
//        });

        // Sides Category Button Logic
        sidesCategoryButton.setOnAction(event -> {
            System.out.println("Navigating to Sides Category");
            Stage stage = (Stage) sidesCategoryButton.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showSidesMenu();
        });
    }

    private void handleItemClick(ActionEvent event) {
        Group g = (Group) ((Button) event.getSource()).getParent();
        ImageView imageView = (ImageView) g.getChildren().getLast();
        Image image = imageView.getImage();

        switch (imageView.getId()) {
            case "bananaImage":
                addItemToCart(MENU_ITEM.BANANA);
                updateUI(image, imageView.getId());
                break;
            case "chocolateImage":
                addItemToCart(MENU_ITEM.SILK);
                updateUI(image, imageView.getId());
                break;
            case "puddingImage":
                addItemToCart(MENU_ITEM.BREADPUDDING);
                updateUI(image, imageView.getId());
                break;
            case "icecreamImage":
                addItemToCart(MENU_ITEM.ICECREAM);
                updateUI(image, imageView.getId());
                break;
        }
    }

    private MENU_ITEM getMenuItem(String id) {
        for (MENU_ITEM i : MENU_ITEM.values()) {
            if (i.id.equalsIgnoreCase(id) || i.getName().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    private void updateUI(Image image, String imageID) {
        // if an item is already in cart, don't add it again
        // just update its quantity label
        if (!cartContainer.getChildren().isEmpty()) {
            for (Node n : cartContainer.getChildren()) {
                Group g = (Group) n;
                // Get 2nd to last item added to the group
                // group.getChildren().addAll(..., itemImageView, quantityLabel);
                ImageView itemImageView = (ImageView) g.getChildren().get(g.getChildren().size() - 2);
                if (itemImageView.getId().equalsIgnoreCase(imageID)) {
                    // get quantity from cart & update label
                    MENU_ITEM mui = getMenuItem(imageID);
                    int quantity = (int) Model.getInstance().currentOrder.desserts.get(mui.getName());
                    Label qLabel = (Label) g.getChildren().getLast();
                    qLabel.setText(String.valueOf(quantity));

                    return; // item is already in cart so don't add another group
                }
            }
        }

        // Create a Group for the item container
        Group group = new Group();

        // Create a Rectangle to serve as the background
        Rectangle backgroundRect = new Rectangle(236, 131);
        backgroundRect.setFill(Color.web("#d9d9d9"));
        backgroundRect.setArcWidth(20);
        backgroundRect.setArcHeight(20);

        Label quantityLabel = new Label(String.valueOf(1));
        quantityLabel.setTextAlignment(TextAlignment.CENTER);
        quantityLabel.setFont(new Font(15));
        quantityLabel.setLayoutX(140);
        quantityLabel.setLayoutY(57);

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
            updateQuantityLabel(event, "add");
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
            updateQuantityLabel(event, "sub");
        });

        // Create ImageView for the item
        ImageView itemImageView = new ImageView(image);
        itemImageView.setId(imageID);
        itemImageView.setLayoutX(23);
        itemImageView.setLayoutY(14);
        itemImageView.setFitWidth(139);
        itemImageView.setFitHeight(104); // Added fitHeight
        itemImageView.setPreserveRatio(true); // Added to preserve aspect ratio

        // Add all elements to the Group
        group.getChildren().addAll(backgroundRect, addButton, subtractButton, itemImageView, quantityLabel);

        // Add the Group to the cart container
        cartContainer.getChildren().add(group);
    }

    private void addItemToCart(MENU_ITEM item) {
        addItemToCart(item, "add");
    }

    private void addItemToCart(MENU_ITEM item, String direction) {
        OrderJSONObject cart = Model.getInstance().getCurrentOrder();
        if (cart.desserts.containsKey(item.getName())) {
            // System.out.println("Item already in order. Updating quantity");
            Integer quantity = (Integer) cart.desserts.get(item.getName());
            if (direction.equalsIgnoreCase("add")) {
                cart.desserts.put(item.getName(), quantity + 1);
            } else {
                if (quantity > 0) {
                    cart.desserts.put(item.getName(), quantity - 1);
                }
            }
        } else {
            // System.out.println("Adding new item to order");
            cart.desserts.put(STR."\{item.getName()}", 1);
        }
        // update current order with everything now in cart
        Model.getInstance().currentOrder = cart;
        // calculate total, taxes, etc...
        updateTransaction();
    }

    private void updateTransaction() {
        float subtotal = 0;
        float taxes = 0;
        float total = 0;
        OrderJSONObject cart = Model.getInstance().currentOrder;

        Set keys = cart.keySet();
        for (Object k : keys) {
            JSONObject category = (JSONObject) cart.get(k);
            Set categoryKey = category.keySet();
            for (Object itemName : categoryKey) {
                Integer itemQuantity = (Integer) category.get(itemName);
                MENU_ITEM mui = getMenuItem(itemName.toString());
                if (mui != null) {
                    subtotal += (mui.price * itemQuantity);
                    taxes += (subtotal * TAX_RATE);
                    total += (subtotal + taxes);
                }
            }
        }
        subtotalValueLabel.setText(String.format("%.2f", subtotal));
        taxValueLabel.setText(String.format("%.2f", taxes));
        totalValueLabel.setText(String.format("%.2f", total));
        Transaction transaction = Model.getInstance().getCurrentTransaction();
        transaction.transaction_amount = total;
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
        Model.getInstance().getViewFactory().showTableWindow();
    }

    // Method to update the quantity label
    private void updateQuantityLabel(ActionEvent event, String direction) {
        // Update UI to display the current quantity
        Group g = (Group) ((Button) event.getSource()).getParent();

        Label qLabel = (Label) g.getChildren().getLast();
        ImageView imageView = (ImageView) g.getChildren().get(g.getChildren().size() - 2);

        MENU_ITEM mui = getMenuItem(imageView.getId());
        addItemToCart(mui, direction);
        int quantity = (int) Model.getInstance().currentOrder.desserts.get(mui.getName());
        qLabel.setText(String.valueOf(quantity));
    }

    // Method to handle checkout action
    private void performCheckout(){
        //Perform checkout actions here
        Model.getInstance().setSelectedTableStatus(JSTable.TABLE_STATUS.FINISHED.name(), false);

        //Navigate to OrderReceiptController/OrderReceipt.fxml
        Stage stage = (Stage) checkoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrderReceiptWindow();
    }
}
