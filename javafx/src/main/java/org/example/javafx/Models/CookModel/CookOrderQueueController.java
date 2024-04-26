package org.example.javafx.Models.CookModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CookOrderQueueController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button readyButtonOne;
    @FXML
    private Button readyButtonTwo;
    @FXML
    private Button readyButtonThree;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        // Logout Button Logic
        logoutButton.setOnAction(event -> {
            System.out.println("Logging out!");
            performLogout();
        });

    }

    // Method to handle logout action
    private void performLogout() {
        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
