//package org.example.javafx.Controllers.Client;
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
//import javafx.scene.control.ToggleButton;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//
//public class WaiterTableController implements Initializable {
//
//
//    // Add @FXML declarations for all 30 ToggleButtons
//    @FXML private ToggleButton tableToggleButton1;
//    @FXML private ToggleButton tableToggleButton2;
//    @FXML private ToggleButton tableToggleButton3;
//    @FXML private ToggleButton tableToggleButton4;
//    @FXML private ToggleButton tableToggleButton5;
//    @FXML private ToggleButton tableToggleButton6;
//    @FXML private ToggleButton tableToggleButton7;
//    @FXML private ToggleButton tableToggleButton8;
//    @FXML private ToggleButton tableToggleButton9;
//    @FXML private ToggleButton tableToggleButton10;
//    @FXML private ToggleButton tableToggleButton11;
//    @FXML private ToggleButton tableToggleButton12;
//    @FXML private ToggleButton tableToggleButton13;
//    @FXML private ToggleButton tableToggleButton14;
//    @FXML private ToggleButton tableToggleButton15;
//    @FXML private ToggleButton tableToggleButton16;
//    @FXML private ToggleButton tableToggleButton17;
//    @FXML private ToggleButton tableToggleButton18;
//    @FXML private ToggleButton tableToggleButton19;
//    @FXML private ToggleButton tableToggleButton20;
//    @FXML private ToggleButton tableToggleButton21;
//    @FXML private ToggleButton tableToggleButton22;
//    @FXML private ToggleButton tableToggleButton23;
//    @FXML private ToggleButton tableToggleButton24;
//    @FXML private ToggleButton tableToggleButton25;
//    @FXML private ToggleButton tableToggleButton26;
//    @FXML private ToggleButton tableToggleButton27;
//    @FXML private ToggleButton tableToggleButton28;
//    @FXML private ToggleButton tableToggleButton29;
//    @FXML private ToggleButton tableToggleButton30;
//    @FXML private Button logoutButton;
//
//    @FXML
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        // Array to store all ToggleButtons
//        ToggleButton[] tableToggleButtons = {
//                tableToggleButton1,
//                tableToggleButton2,
//                tableToggleButton3,
//                tableToggleButton4,
//                tableToggleButton5,
//                tableToggleButton6,
//                tableToggleButton7,
//                tableToggleButton8,
//                tableToggleButton9,
//                tableToggleButton10,
//                tableToggleButton11,
//                tableToggleButton12,
//                tableToggleButton13,
//                tableToggleButton14,
//                tableToggleButton15,
//                tableToggleButton16,
//                tableToggleButton17,
//                tableToggleButton18,
//                tableToggleButton19,
//                tableToggleButton20,
//                tableToggleButton21,
//                tableToggleButton22,
//                tableToggleButton23,
//                tableToggleButton24,
//                tableToggleButton25,
//                tableToggleButton26,
//                tableToggleButton27,
//                tableToggleButton28,
//                tableToggleButton29,
//                tableToggleButton30
//        };
//
//        //Table Buttons
//
//
//
//        //loop is broken/doesn't work ... need to debug - ryan
//
//        // Loop through all ToggleButtons and add listeners
//        for (int i = 1; i <= 30; i++) {
//            ToggleButton button = getToggleButtonById("tableToggleButton" + i);
//            if (button != null) {
//                button.selectedProperty().addListener((observable, oldValue, newValue) -> {
//                    if (newValue) {
//                        String tableName = button.getText();
//                        System.out.println("Selected Table: " + tableName);
//                    }
//                });
//            }
//        }
//
//        //Logout Button Logic
//        logoutButton.setOnAction(event -> {
//            performLogout();
//        });
//    }
//
//    // Helper method to get ToggleButton by ID dynamically
//
//
//    private ToggleButton getToggleButtonById(String id) {
//        ToggleButton button = null;
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml"));
//            loader.load();
//            button = (ToggleButton) loader.getNamespace().get(id);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return button;
//    }
//
//    // You can add more methods to handle other UI interactions or events
//    private void performLogout() {
//        // Perform logout actions here
//        System.out.println("User logged out.");
//
//        // You may navigate to the login screen
//        Stage stage = (Stage) logoutButton.getScene().getWindow();
//        Model.getInstance().getViewFactory().closeStage(stage);
//    }
//}

package org.example.javafx.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WaiterTableController implements Initializable {

    // Add @FXML declarations for all 30 ToggleButtons
    @FXML private ToggleButton tableToggleButton1;
    @FXML private ToggleButton tableToggleButton2;
    @FXML private ToggleButton tableToggleButton3;
    @FXML private ToggleButton tableToggleButton4;
    @FXML private ToggleButton tableToggleButton5;
    @FXML private ToggleButton tableToggleButton6;
    @FXML private ToggleButton tableToggleButton7;
    @FXML private ToggleButton tableToggleButton8;
    @FXML private ToggleButton tableToggleButton9;
    @FXML private ToggleButton tableToggleButton10;
    @FXML private ToggleButton tableToggleButton11;
    @FXML private ToggleButton tableToggleButton12;
    @FXML private ToggleButton tableToggleButton13;
    @FXML private ToggleButton tableToggleButton14;
    @FXML private ToggleButton tableToggleButton15;
    @FXML private ToggleButton tableToggleButton16;
    @FXML private ToggleButton tableToggleButton17;
    @FXML private ToggleButton tableToggleButton18;
    @FXML private ToggleButton tableToggleButton19;
    @FXML private ToggleButton tableToggleButton20;
    @FXML private ToggleButton tableToggleButton21;
    @FXML private ToggleButton tableToggleButton22;
    @FXML private ToggleButton tableToggleButton23;
    @FXML private ToggleButton tableToggleButton24;
    @FXML private ToggleButton tableToggleButton25;
    @FXML private ToggleButton tableToggleButton26;
    @FXML private ToggleButton tableToggleButton27;
    @FXML private ToggleButton tableToggleButton28;
    @FXML private ToggleButton tableToggleButton29;
    @FXML private ToggleButton tableToggleButton30;
    @FXML private Button logoutButton;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Loop through all ToggleButtons and add listeners
        for (int i = 1; i <= 30; i++) {
            ToggleButton button = getToggleButtonById("tableToggleButton" + i);
            if (button != null) {
                int finalI = i; // Capture the value of i in a final variable
                button.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Button " + finalI + " clicked."); // Print a debug statement
                    if (newValue) {
                        String tableName = "Table " + finalI; // Use finalI here instead of i
                        System.out.println("Selected Table: " + tableName);
                    }
                });
            }
        }

        // Logout Button Logic
        logoutButton.setOnAction(event -> performLogout());
    }


    // Helper method to get ToggleButton by ID dynamically
    private ToggleButton getToggleButtonById(String id) {
        switch (id) {
            case "tableToggleButton1":
                return tableToggleButton1;
            case "tableToggleButton2":
                return tableToggleButton2;
            case "tableToggleButton3":
                return tableToggleButton3;
            case "tableToggleButton4":
                return tableToggleButton4;
            case "tableToggleButton5":
                return tableToggleButton5;
            case "tableToggleButton6":
                return tableToggleButton6;
            case "tableToggleButton7":
                return tableToggleButton7;
            case "tableToggleButton8":
                return tableToggleButton8;
            case "tableToggleButton9":
                return tableToggleButton9;
            case "tableToggleButton10":
                return tableToggleButton10;
            case "tableToggleButton11":
                return tableToggleButton11;
            case "tableToggleButton12":
                return tableToggleButton12;
            case "tableToggleButton13":
                return tableToggleButton13;
            case "tableToggleButton14":
                return tableToggleButton14;
            case "tableToggleButton15":
                return tableToggleButton15;
            case "tableToggleButton16":
                return tableToggleButton16;
            case "tableToggleButton17":
                return tableToggleButton17;
            case "tableToggleButton18":
                return tableToggleButton18;
            case "tableToggleButton19":
                return tableToggleButton19;
            case "tableToggleButton20":
                return tableToggleButton20;
            case "tableToggleButton21":
                return tableToggleButton21;
            case "tableToggleButton22":
                return tableToggleButton22;
            case "tableToggleButton23":
                return tableToggleButton23;
            case "tableToggleButton24":
                return tableToggleButton24;
            case "tableToggleButton25":
                return tableToggleButton25;
            case "tableToggleButton26":
                return tableToggleButton26;
            case "tableToggleButton27":
                return tableToggleButton27;
            case "tableToggleButton28":
                return tableToggleButton28;
            case "tableToggleButton29":
                return tableToggleButton29;
            case "tableToggleButton30":
                return tableToggleButton30;
            default:
                return null;
        }
    }


    // Method to handle logout action
    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
