package org.example.javafx.Models.ManagerModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerCreateAccountInfoController implements Initializable {
    @FXML private Button logoutButton;
    @FXML private Button backButton;
    @FXML private Button resetAccount;

    @FXML private Button createButton;
    @FXML private Label createLabel;

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

        // Reset Account Login Button Logic
        resetAccount.setOnAction(event -> {
            System.out.printf("Navigating to Reset User/Pass Page...");
            performResetAccInfo();
        });

        //Create Button Logic
        createButton.setOnAction(event -> {
            System.out.println("Account Created!");
            performCreateAccount();
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

    // Method to create account info
    private void performCreateAccount(){
        createLabel.setText("Account Created!");

        /* Save new account info into the database*/
    }

    // Method to handle reset account info navigation
    private void performResetAccInfo(){
        Stage stage = (Stage) resetAccount.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerResetAccountInformation();
    }
}
