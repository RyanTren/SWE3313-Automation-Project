package org.example.javafx.Models.BusboyModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.example.database.Employee;
import org.example.database.JSTable;
import org.example.javafx.Models.Model;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableConditionsController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private Button backButton;
    @FXML
    private Button nameLabelButton;

    @FXML
    private ListView<Button> dirtyTableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Employee user = Model.getInstance().getCurrentUser();
        nameLabelButton.setText(String.format("Welcome, %s", user.name));
        nameLabelButton.setDisable(true);
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

        // initialize list
        ArrayList<JSTable> tables = JSTable.getAllTables();
        for (JSTable t : tables) {
            if (t.clean) continue;
            Button button = new Button(STR."Table \{t.id}");
            button.setStyle("-fx-background-color: #B51D1D; -fx-background-radius: 25");
            button.setTextFill(Paint.valueOf("WHITE"));
            button.setFont(new Font(25));

            button.setPadding(new Insets(5, 0, 5, 0));
            button.setTextAlignment(TextAlignment.CENTER);
            button.setMaxWidth(Double.MAX_VALUE);

            button.setOnAction(event -> {
                Button clicked = (Button) event.getSource();
                Integer tableID = Integer.parseInt(clicked.getText().split(" ")[1]);
                JSTable table = JSTable.get(tableID);
                if (table != null) {
                    table.clean = true;
                    table.status = "available";
                    table.save();
                    // remove it from view
                    dirtyTableList.getItems().remove(clicked);
                }
            });
            dirtyTableList.getItems().add(button);
        }
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
        Model.getInstance().getViewFactory().showTableWindow();
    }
}
