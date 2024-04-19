package org.example.javafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.javafx.App;
import org.example.javafx.Models.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            boolean loginSuccessful = performLogin();
            if (loginSuccessful) {
                onLogin();
            } else {
                errorLabel.setText("Error: Invalid username or password.");
            }
        });
    }

    private boolean performLogin() {
        // Hardcoded username and password
        String validUsername = "w1user";
        String validPassword = "w1password";

        //@Prince @Shams when you guys are free can you put the DB connection/implementation here :) thanks!

        // Retrieve entered username and password from fields
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        // Check if entered username and password match the valid credentials
        boolean isValid = validUsername.equals(enteredUsername) && validPassword.equals(enteredPassword);
        System.out.println("Logging in!");
        return isValid;
    }


    private void onLogin(){
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showWaiterTableWindow();
    }
}
