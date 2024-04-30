package org.example.javafx.Models.ManagerModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerResetAccountInformation implements Initializable {
    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button createAccount;

    @FXML private Button resetButton;
    @FXML private Label resetLabel;

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

        // Create Account Login Button Logic
        createAccount.setOnAction(event -> {
            System.out.printf("Navigating to Reset User/Pass Page...");
            performCreateAcc();
        });

        //Reset Button Logic
        resetButton.setOnAction(event -> {
            System.out.println("Account Info Reset!");
            performResetAccount();
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

    private void performCreateAcc(){
        Stage stage = (Stage) createAccount.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerCreateAccountInformation();
    }

    // Method to create account info
    private void performResetAccount(){
        resetLabel.setText("Reset Account Info!");

        /* Save new account info into the database*/
    }
}
