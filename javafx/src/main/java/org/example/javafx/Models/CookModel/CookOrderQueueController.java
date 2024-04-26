package org.example.javafx.Models.CookModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CookOrderQueueController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button readyButtonOne;
    @FXML
    private Button readyButtonTwo;
    @FXML
    private Button readyButtonThree;

    @FXML private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        // Logout Button Logic
        logoutButton.setOnAction(event -> {
            System.out.println("Logging out!");
            performLogout();
        });

        // Ready Button One Logic
        readyButtonOne.setOnAction(event -> {
            System.out.println("Order One is ready!");
            removeGroup((Group) readyButtonOne.getParent());
        });

        // Ready Button Two Logic
        readyButtonTwo.setOnAction(event -> {
            System.out.println("Order Two is ready!");
            removeGroup((Group) readyButtonTwo.getParent());
        });

        // Ready Button Three Logic
        readyButtonThree.setOnAction(event -> {
            System.out.println("Order Three is ready!");
            removeGroup((Group) readyButtonThree.getParent());
        });
    }

    // Method to handle logout action
    private void performLogout() {
        // You may navigate to the login screen
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    // Method to remove a group from the AnchorPane
    private void removeGroup(Group group) {
        anchorPane.getChildren().remove(group);
    }
}
