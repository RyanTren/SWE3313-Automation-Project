package org.example.javafx.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

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
        // Array to store all ToggleButtons
        ToggleButton[] tableToggleButtons = {
                tableToggleButton1,
                tableToggleButton2,
                // Add other ToggleButtons here...
        };

        //Table Buttons
        //loop is broken/doesn't work ... need to debug - ryan

        // Loop through all ToggleButtons and add listeners
        for (ToggleButton button : tableToggleButtons) {
            if (button != null) {
                button.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        // Handle the selection of the toggle button
                        String tableName = button.getText();
                        System.out.println("Selected Table: " + tableName);
                    }
                });
            }
        }

        //Logout Button Logic
        logoutButton.setOnAction(event -> {
            performLogout();
        });
    }

    // You can add more methods to handle other UI interactions or events
    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
