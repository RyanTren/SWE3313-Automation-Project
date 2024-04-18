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
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if username and password are not empty
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Username and password are required.");
            return;
        }

        // Here you can add logic to validate the username and password,
        // authenticate the user, and navigate to another scene if login is successful.
        // For example:
        if (isValidCredentials(username, password)) {
            // Navigate to another scene
            // Example:
            // primaryStage.setScene(new Scene(root, width, height));
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Add your logic to validate the username and password here.
        // This is just a placeholder, you should replace it with your actual logic.
        return username.equals("admin") && password.equals("password");
    }
}
