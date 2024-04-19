package org.example.javafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.javafx.App;

import java.io.IOException;

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
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Fxml/WaiterTable.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) loginButton.getScene().getWindow(); // Get the current stage
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                // Display an error message if the FXML file fails to load
                errorLabel.setText("Error loading waiter table screen.");
            }
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
