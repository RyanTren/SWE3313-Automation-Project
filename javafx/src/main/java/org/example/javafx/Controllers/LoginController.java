package org.example.javafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.database.Employee;
import org.example.javafx.Models.Model;

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

    private static Employee currentUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            boolean loginSuccessful = performLogin();
            if (loginSuccessful) {
                System.out.println("Logging in!");
                onLogin();
            } else {
                errorLabel.setText("Error: Invalid username or password.");
                System.out.println("Error: Invalid username or password.");
            }
        });
    }

    private boolean performLogin() {
        // Retrieve entered username and password from fields
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        // Check if entered username and password match the valid credentials
        Employee user = Employee.getByUsername(enteredUsername);
        System.out.println(user);
        if (user != null) {
            if (user.password.equalsIgnoreCase(enteredPassword)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }


    private void onLogin() {
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        switch (currentUser.role) {
            case "waiter", "host":
                Model.getInstance().getViewFactory().showWaiterTableWindow();
                break;
            case "manager":
                Model.getInstance().getViewFactory().showManagerAdminPanel();
                break;

//            case "cook":
//
//                break;
//
//            case "busboy":
//                break;
        }
    }
}
