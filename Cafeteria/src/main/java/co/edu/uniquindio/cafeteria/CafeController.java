package co.edu.uniquindio.cafeteria;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.CafeSimple;
import co.edu.uniquindio.cafeteria.Model.Decorations.AzucarDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.CanelaDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.LecheDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.WhiskyDecorator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CafeController implements Initializable {

    @FXML private CheckBox lecheCheckBox;
    @FXML private CheckBox azucarCheckBox;
    @FXML private CheckBox wiskyCheckBox;
    @FXML private CheckBox canelaCheckBox;

    @FXML private RadioButton especialRadio;
    @FXML private RadioButton pasillaRadio;
    @FXML private ToggleGroup tipoCafeGroup;

    @FXML private Button calcularButton;
    @FXML private Button metodoButton;

    @FXML private Label costoLabel;
    @FXML private Label ingredientesLabel;

    private DecimalFormat df = new DecimalFormat("#.#");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        especialRadio.setSelected(true);

        // Agregar listeners para cálculo automático
        lecheCheckBox.setOnAction(e -> calcular());
        azucarCheckBox.setOnAction(e -> calcular());
        wiskyCheckBox.setOnAction(e -> calcular());
        canelaCheckBox.setOnAction(e -> calcular());
        especialRadio.setOnAction(e -> calcular());
        pasillaRadio.setOnAction(e -> calcular());

        // Cálculo inicial
        calcular();
    }

    @FXML
    public void calcular() {
        try {

            String tipoCafe = especialRadio.isSelected() ? "Especial" : "Pasilla";
            Cafe cafe = new CafeSimple(tipoCafe);


            if (lecheCheckBox.isSelected()) {
                cafe = new LecheDecorator(cafe);
            }
            if (azucarCheckBox.isSelected()) {
                cafe = new AzucarDecorator(cafe);
            }
            if (wiskyCheckBox.isSelected()) {
                cafe = new WhiskyDecorator(cafe);
            }
            if (canelaCheckBox.isSelected()) {
                cafe = new CanelaDecorator(cafe);
            }

            costoLabel.setText("Costo: $" + df.format(cafe.getCosto()));
            ingredientesLabel.setText("Ingredientes: " + cafe.getDescripcion());

        } catch (Exception e) {
            mostrarError("Error al calcular", "Ocurrió un error durante el cálculo: " + e.getMessage());
        }
    }


    @FXML
    public void mostrarMetodo() {
        StringBuilder metodo = new StringBuilder();
        metodo.append("MÉTODO DE PREPARACIÓN:\n\n");

        String tipoCafe = especialRadio.isSelected() ? "Especial" : "Pasilla";
        metodo.append("1. Preparar café ").append(tipoCafe.toLowerCase()).append("\n");

        int paso = 2;
        if (lecheCheckBox.isSelected()) {
            metodo.append(paso++).append(". Agregar leche caliente\n");
        }
        if (azucarCheckBox.isSelected()) {
            metodo.append(paso++).append(". Endulzar con azúcar al gusto\n");
        }
        if (wiskyCheckBox.isSelected()) {
            metodo.append(paso++).append(". Añadir unas gotas de whisky\n");
        }
        if (canelaCheckBox.isSelected()) {
            metodo.append(paso++).append(". Espolvorear canela en polvo\n");
        }

        metodo.append(paso).append(". Mezclar suavemente y servir caliente\n");
        metodo.append("\n¡Disfrute su café!");

        mostrarInformacion("Método de Preparación", metodo.toString());
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 300);
        alert.showAndWait();
    }
}