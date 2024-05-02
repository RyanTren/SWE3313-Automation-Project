package org.example.javafx.Models.WaiterModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.example.database.JSTable;
import org.example.database.Transaction;
import org.example.javafx.Models.Model;
import org.example.javafx.Models.OrderJSONObject;
import org.json.simple.JSONObject;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Set;

public class OrderReceiptController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private Button backButton;
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Transaction transaction = Model.getInstance().getCurrentTransaction();
        OrderJSONObject cart = Model.getInstance().getCurrentOrder();
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

        StringBuilder output = new StringBuilder();
        Set keys = cart.keySet();
        for (Object k : keys) {
            JSONObject category = (JSONObject) cart.get(k);
            Set categoryKey = category.keySet();
            for (Object itemName : categoryKey) {
                Integer itemQuantity = (Integer) category.get(itemName);
                output.append(String.format("%s (%d)\n", itemName, itemQuantity));
            }
        }
        output.append("--------------------------\n");
        output.append(String.format("Subtotal:%15s\n", DecimalFormat.getCurrencyInstance().format(transaction.subtotal)));
        output.append(String.format("Tax:%22s\n", DecimalFormat.getCurrencyInstance().format(transaction.taxes)));
        output.append("--------------------------\n");
        output.append(String.format("Total:%22s", DecimalFormat.getCurrencyInstance().format(transaction.transaction_amount)));
        textArea.setText(output.toString());
    }

    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // reset everything
        Model.getInstance().currentOrder = null;
        Model.getInstance().currentTransaction = null;
        Model.getInstance().setSelectedTableStatus(JSTable.TABLE_STATUS.FINISHED.name(), false);

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    // Method to handle back action
    private void performBack() {
        // Perform back actions here
        System.out.println("User went back a screen.");

        // reset everything
        Model.getInstance().currentOrder = null;
        Model.getInstance().currentTransaction = null;
        Model.getInstance().setSelectedTableStatus(JSTable.TABLE_STATUS.FINISHED.name(), false);
        // You may navigate to the previous screen
        Stage stage = (Stage) backButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showTableWindow();
    }
}
