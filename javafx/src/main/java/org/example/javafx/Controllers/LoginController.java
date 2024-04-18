package org.example.javafx.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel; // Add a label to display error messages

    @FXML
    private void initialize() {
        // Initialization code, if any
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidCredentials(username, password)) {
            // Login successful, print "login" in the console
            System.out.println("Login");
            // Clear any previous error message
            errorLabel.setText("");
        } else {
            // Login failed, display error message
            errorLabel.setText("Invalid username or password.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Check if the provided username and password match the desired credentials
        return username.equals("w1user") && password.equals("w1password");
    }
}
