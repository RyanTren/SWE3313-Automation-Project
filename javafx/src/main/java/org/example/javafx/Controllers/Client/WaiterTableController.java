package org.example.javafx.Controllers.Client;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class WaiterTableController {

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
    @FXML
    private void initialize() {
        // Array to store all ToggleButtons
        ToggleButton[] tableToggleButtons = {
                tableToggleButton1,
                tableToggleButton2,
                // Add other ToggleButtons here...
        };

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
    }

    // You can add more methods to handle other UI interactions or events
}
