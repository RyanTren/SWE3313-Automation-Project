package org.example.javafx.Controllers.Client;

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

public class LogoutController implements Initializable {

    @FXML
    private Button logoutButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoutButton.setOnAction(event -> {
            performLogout();
            System.out.println("Logging out!");
            onLogout();
        });
    }

    private void performLogout() {
        // Perform logout actions here
        System.out.println("User logged out.");

        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }


    private void onLogout(){
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showWaiterTableWindow();
    }
}
