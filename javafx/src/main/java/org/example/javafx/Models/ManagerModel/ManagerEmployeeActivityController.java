package org.example.javafx.Models.ManagerModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerEmployeeActivityController implements Initializable {
    @FXML private Button logoutButton;
    @FXML private Button backButton;

    @FXML private Button hostActivityButton;
    @FXML private Button waiterActivityButton;
//    @FXML private Button busboyActivityButton;
//    @FXML private Button cookActivityButton;

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

        hostActivityButton.setOnAction(event -> {
            System.out.println("Navigating Host View...");
            performNavToWaiter();
        });

        waiterActivityButton.setOnAction(event -> {
            System.out.println("Navigating Waiter View...");
            performNavToWaiter();
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

    private void performNavToWaiter(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showWaiterTableWindow();
    }
}
