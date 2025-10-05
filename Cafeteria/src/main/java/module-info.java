module co.edu.uniquindio.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cafeteria to javafx.fxml;
    exports co.edu.uniquindio.cafeteria;
    exports co.edu.uniquindio.cafeteria.Controller;
    opens co.edu.uniquindio.cafeteria.Controller to javafx.fxml;
}