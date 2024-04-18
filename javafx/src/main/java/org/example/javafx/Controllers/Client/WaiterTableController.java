package org.example.javafx.Controllers.Client;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup; // Correct import

public class WaiterTableController {

    @FXML
    private ToggleGroup tableToggleGroup1; // Corrected variable name

    @FXML
    private ToggleGroup tableToggleGroup2; // Corrected variable name

    // Add similar declarations for other ToggleGroups if needed

    @FXML
    private void initialize() {
        // You can add initialization code here
        // For example, setting initial state or handling events
        tableToggleGroup1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ToggleButton selectedToggleButton = (ToggleButton) newValue;
                String tableName = selectedToggleButton.getText();
                // Handle the selection of the toggle button
                System.out.println("Selected Table: " + tableName);
            }
        });

        // Add similar listener for other ToggleGroups if needed
    }

    // You can add more methods to handle other UI interactions or events
}
