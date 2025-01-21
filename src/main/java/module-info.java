module fooddelivery {
    requires javafx.fxml;
    requires javafx.controls;

    exports org.example to javafx.graphics;

    opens org.example.controllers to javafx.fxml;
}