package org.example.javafx.Models.ManagerModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SalesAnalyticsController implements Initializable {
    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button nextButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
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

        // Next Button Logic
        nextButton.setOnAction(event -> {
            System.out.println("Navigating to By-Day Analytics");
            performNext();
        });
    }

    // Method to handle logout action
    private void performLogout() {
        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    // Method to handle back action
    private void performBack() {
        // You may navigate to the previous screen
        Stage stage = (Stage) backButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerAdminPanel();
    }

    // Method to handle next action
    private void performNext() {
        // You may navigate to the previous screen
        Stage stage = (Stage) nextButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showByDayAnalytics();
    }
}
