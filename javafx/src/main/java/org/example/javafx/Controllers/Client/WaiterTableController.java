package org.example.javafx.Controllers.Client;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
                        onClickTable(); // Call onClickTable method when a table button is selected
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


    // Method to handle logout action
    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    //tableButton now transitions to the DrinksMenu.fxml but, you have to double-click the button. (need to fix this)
//    private void onClickTable() {
//        try {
//            // Load the FXML file for the drinks menu
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/DrinksMenu.fxml"));
//            AnchorPane drinksMenuPane = loader.load();
//
//            // Get the current stage
//            Stage currentStage = (Stage) tableToggleButton1.getScene().getWindow();
//
//            // Create a new stage for the drinks menu
//            Stage drinksMenuStage = new Stage();
//            drinksMenuStage.setScene(new Scene(drinksMenuPane));
//
//            // Close the current stage and show the drinks menu stage
//            currentStage.close();
//            drinksMenuStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void onClickTable() {
        try {
            // Show the drinks menu using ViewFactory
            Model.getInstance().getViewFactory().showDrinksMenu();

            // Close the current stage (optional)
            Stage currentStage = (Stage) tableToggleButton1.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
