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


    private boolean isValidCredentials(String username, String password) {
        // Add your logic to validate the username and password here.
        // This is just a placeholder, you should replace it with your actual logic.
        return username.equals("admin") && password.equals("password");
    }
}
