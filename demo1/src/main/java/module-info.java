
module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.modeo;
    opens com.example.demo1.modeo to javafx.fxml;
    exports com.example.demo1.interfases;
    opens com.example.demo1.interfases to javafx.fxml;
    exports com.example.demo1.motor;
    opens com.example.demo1.motor to javafx.fxml;
}