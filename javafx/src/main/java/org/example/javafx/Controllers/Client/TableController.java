package org.example.javafx.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.example.database.Employee;
import org.example.database.JSTable;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    // Add @FXML declarations for all 30 ToggleButtons
    @FXML
    private ToggleButton tableToggleButton1;
    @FXML
    private ToggleButton tableToggleButton2;
    @FXML
    private ToggleButton tableToggleButton3;
    @FXML
    private ToggleButton tableToggleButton4;
    @FXML
    private ToggleButton tableToggleButton5;
    @FXML
    private ToggleButton tableToggleButton6;
    @FXML
    private ToggleButton tableToggleButton7;
    @FXML
    private ToggleButton tableToggleButton8;
    @FXML
    private ToggleButton tableToggleButton9;
    @FXML
    private ToggleButton tableToggleButton10;
    @FXML
    private ToggleButton tableToggleButton11;
    @FXML
    private ToggleButton tableToggleButton12;
    @FXML
    private ToggleButton tableToggleButton13;
    @FXML
    private ToggleButton tableToggleButton14;
    @FXML
    private ToggleButton tableToggleButton15;
    @FXML
    private ToggleButton tableToggleButton16;
    @FXML
    private ToggleButton tableToggleButton17;
    @FXML
    private ToggleButton tableToggleButton18;
    @FXML
    private ToggleButton tableToggleButton19;
    @FXML
    private ToggleButton tableToggleButton20;
    @FXML
    private ToggleButton tableToggleButton21;
    @FXML
    private ToggleButton tableToggleButton22;
    @FXML
    private ToggleButton tableToggleButton23;
    @FXML
    private ToggleButton tableToggleButton24;
    @FXML
    private ToggleButton tableToggleButton25;
    @FXML
    private ToggleButton tableToggleButton26;
    @FXML
    private ToggleButton tableToggleButton27;
    @FXML
    private ToggleButton tableToggleButton28;
    @FXML
    private ToggleButton tableToggleButton29;
    @FXML
    private ToggleButton tableToggleButton30;
    @FXML
    private Button logoutButton;

    @FXML
    private Label roleName;

    public enum TABLE_STATUS {
        OCCUPIED("-fx-background-color: #e5dd16"),
        AVAILABLE("-fx-background-color: #59BC63"),
        FINISHED("-fx-background-color: #d21f1f");

        public final String style;

        private TABLE_STATUS(String style) {
            this.style = style;
        }

    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<JSTable> restaurantTables = JSTable.getAllTables();
        // Set roleName label text based on current user's role
        Employee user = Model.getInstance().getCurrentUser();
        if (user != null) {
            roleName.setText(user.name);
        } else {
            roleName.setText("Welcome back");
        }

        // Loop through all ToggleButtons and add listeners
        for (int i = 1; i <= 30; i++) {
            ToggleButton button = getToggleButtonById("tableToggleButton" + i);
            if (button != null) {
                int finalI = i; // Capture the value of i in a final variable
                // apply status stored in db
                JSTable t = restaurantTables.get(i - 1);
                boolean tableOccupied = t.status.equalsIgnoreCase(TABLE_STATUS.OCCUPIED.name());
                boolean tableFinished = t.status.equalsIgnoreCase(TABLE_STATUS.FINISHED.name());
                boolean tableAvailable = t.status.equalsIgnoreCase(TABLE_STATUS.AVAILABLE.name());

                if (!Model.getInstance().getCurrentUser().role.equalsIgnoreCase("busboy")) {
                    // only "available" tables are clickable
                    button.setDisable(tableOccupied || tableFinished);
                } else {
                    // bus boy can only click finished tables
                    button.setDisable(tableAvailable || tableOccupied);

                }
                button.setStyle(TABLE_STATUS.valueOf(t.status.toUpperCase()).style);
                button.setOnAction(event -> {
                    onClickTable(button); // Call onClickTable method when a table button is clicked
                    String tableName = "Table " + finalI; // Use finalI here instead of i
                    System.out.println("Selected Table: " + tableName);
                });
            }
        }

        // Logout Button Logic
        logoutButton.setOnAction(event -> performLogout());
    }

    // Helper method to get ToggleButton by ID dynamically
    private ToggleButton getToggleButtonById(String id) {
        return switch (id) {
            case "tableToggleButton1" -> tableToggleButton1;
            case "tableToggleButton2" -> tableToggleButton2;
            case "tableToggleButton3" -> tableToggleButton3;
            case "tableToggleButton4" -> tableToggleButton4;
            case "tableToggleButton5" -> tableToggleButton5;
            case "tableToggleButton6" -> tableToggleButton6;
            case "tableToggleButton7" -> tableToggleButton7;
            case "tableToggleButton8" -> tableToggleButton8;
            case "tableToggleButton9" -> tableToggleButton9;
            case "tableToggleButton10" -> tableToggleButton10;
            case "tableToggleButton11" -> tableToggleButton11;
            case "tableToggleButton12" -> tableToggleButton12;
            case "tableToggleButton13" -> tableToggleButton13;
            case "tableToggleButton14" -> tableToggleButton14;
            case "tableToggleButton15" -> tableToggleButton15;
            case "tableToggleButton16" -> tableToggleButton16;
            case "tableToggleButton17" -> tableToggleButton17;
            case "tableToggleButton18" -> tableToggleButton18;
            case "tableToggleButton19" -> tableToggleButton19;
            case "tableToggleButton20" -> tableToggleButton20;
            case "tableToggleButton21" -> tableToggleButton21;
            case "tableToggleButton22" -> tableToggleButton22;
            case "tableToggleButton23" -> tableToggleButton23;
            case "tableToggleButton24" -> tableToggleButton24;
            case "tableToggleButton25" -> tableToggleButton25;
            case "tableToggleButton26" -> tableToggleButton26;
            case "tableToggleButton27" -> tableToggleButton27;
            case "tableToggleButton28" -> tableToggleButton28;
            case "tableToggleButton29" -> tableToggleButton29;
            case "tableToggleButton30" -> tableToggleButton30;
            default -> null;
        };
    }

//    private void onClickTable(ToggleButton tableButton) {
//        try {
//            // Set the background color of the clicked table button to yellow
//            tableButton.setStyle("-fx-background-color: #e5dd16");
//
//            // Set the text of the clicked table button to "Occupied"
////            tableButton.setText("Occupied");
//            System.out.println("Occupied");
//
//            // You may want to disable the button after it's been clicked
//            tableButton.setDisable(true);
//
//            // Show the drinks menu using ViewFactory
//            Model.getInstance().getViewFactory().showDrinksMenu();
//
//            // Close the current stage (optional)
//            Stage currentStage = (Stage) tableButton.getScene().getWindow();
//            currentStage.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void onClickTable(ToggleButton tableButton) {
        try {
            // Set the background color of the clicked table button to yellow
            tableButton.setStyle(TABLE_STATUS.OCCUPIED.style);

            // update table status in DB
            int tableID = Integer.parseInt(tableButton.getText().split(" ")[1]);
            JSTable jt = JSTable.get(tableID);
            if (jt != null) {
                jt.status = TABLE_STATUS.OCCUPIED.name();
                jt.clean = false;
                jt.save();
            }

            // You may want to disable the button after it's been clicked
            tableButton.setDisable(true);
            Model.getInstance().setCurrentTableID(tableID);

            // Determine the user's role
            Employee user = Model.getInstance().getCurrentUser();

            // Redirect based on the user's role
            if (user != null && user.role.equalsIgnoreCase("busboy")) {
                // Redirect to TableConditionsController
                Model.getInstance().getViewFactory().showTableConditions();
            } else {
                // Show the drinks menu for other roles
                Model.getInstance().getViewFactory().showDrinksMenu();
            }

            // Close the current stage (optional)
            Stage currentStage = (Stage) tableButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
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

//    private void onClickTable() {
//        try {
//            // Show the drinks menu using ViewFactory
//            Model.getInstance().getViewFactory().showDrinksMenu();
//
//            // Close the current stage (optional)
//            Stage currentStage = (Stage) tableToggleButton1.getScene().getWindow();
//            currentStage.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
