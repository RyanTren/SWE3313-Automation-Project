//module org.example.javafx {
//    requires javafx.controls;
//    requires javafx.fxml;
//
//    opens org.example.javafx.Models to javafx.fxml;
//    opens org.example.javafx.Controllers to javafx.fxml;
//
//    exports org.example.javafx;
//
//    // Add this line to open the Client package to javafx.fxml
//    opens org.example.javafx.Controllers.Client to javafx.fxml;
//
//    // other module directives
//}
//
//
//

module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics; // Add this line to allow access to java.awt
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;
    requires norm;
    requires java.persistence;
    requires json.simple;

    opens org.example.javafx.Models to javafx.fxml;
    opens org.example.javafx.Controllers to javafx.fxml;
    opens org.example.javafx.Controllers.Client to javafx.fxml;
    opens org.example.javafx.Models.ManagerModel to javafx.fxml;
    opens org.example.javafx.Models.CookModel to javafx.fxml;
    opens org.example.javafx.Models.BusboyModel to javafx.fxml;



    exports org.example.javafx;
    exports org.example.database;
    opens org.example.javafx.Models.WaiterModel to javafx.fxml;
}

