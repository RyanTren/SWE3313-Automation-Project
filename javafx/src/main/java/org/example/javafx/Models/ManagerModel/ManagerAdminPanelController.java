package org.example.javafx.Models.ManagerModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerAdminPanelController implements Initializable {
    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button accountOverviewButton;
    @FXML private Button employeeActivityButton;
    @FXML private Button inventoryStatusButton;
    @FXML private Button salesAnalyticsButton;


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

        // Account Overview Button Logic
        accountOverviewButton.setOnAction(event -> {
            System.out.println("Navigating to Account Overview");
            performAccountOverview();
        });

        // Employee Activity Button Logic
        employeeActivityButton.setOnAction(event -> {
            System.out.println("Navigating to Employee Activity");
            performEmployeeActivity();
        });

        // Inventory Status Button Logic
        inventoryStatusButton.setOnAction(event -> {
            System.out.println("Navigating to Inventory Status");
            performInventoryStatus();
        });

        salesAnalyticsButton.setOnAction(event -> {
            System.out.println("Navigating to Sales Analytics");
            performSalesAnalytics();
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
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    // Method to navigate to ManagerCreateAccountOverview
    private void performAccountOverview(){
        Stage stage = (Stage) accountOverviewButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerCreateAccountInformation();
    }

    // Method to navigate to ManagerEmployeeActivityController
    private void performEmployeeActivity(){
        Stage stage = (Stage) employeeActivityButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerEmployeeActivity();
    }

    // Method to navigate to InventoryScreenController
    private void performInventoryStatus(){
        Stage stage = (Stage) inventoryStatusButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showInventoryScreen();
    }

    // Method to navigate to SalesAnalyticsController
    private void performSalesAnalytics(){
        Stage stage = (Stage) salesAnalyticsButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSalesAnalytics();
    }
}
