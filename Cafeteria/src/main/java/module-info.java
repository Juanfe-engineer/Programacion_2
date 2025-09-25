module co.edu.uniquindio.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cafeteria to javafx.fxml;
    exports co.edu.uniquindio.cafeteria;
}