package co.edu.uniquindio.cafeteria.Controller;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.CafeSimple;
import co.edu.uniquindio.cafeteria.Model.Decorations.AzucarDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.CanelaDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.LecheDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.WhiskyDecorator;
import co.edu.uniquindio.cafeteria.Model.Strategy.MetodoPreparacion;
import co.edu.uniquindio.cafeteria.Model.Strategy.MetodoExpresso;
import co.edu.uniquindio.cafeteria.Model.Strategy.MetodoFiltrado;
import co.edu.uniquindio.cafeteria.Model.Strategy.MetodoFrances;
import co.edu.uniquindio.cafeteria.Model.Observer.CafeteriaObservable;
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
    @FXML private ComboBox<String> metodoComboBox;

    @FXML private Label costoLabel;
    @FXML private Label ingredientesLabel;

    private DecimalFormat df = new DecimalFormat("#.#");
    private MetodoPreparacion metodoSeleccionado;
    private CafeteriaObservable cafeteriaObservable;

    public void setCafeteriaObservable(CafeteriaObservable observable) {
        this.cafeteriaObservable = observable;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        especialRadio.setSelected(true);

        // Configurar ComboBox con métodos de preparación
        metodoComboBox.getItems().addAll("Espresso", "Filtrado", "Prensa Francesa");
        metodoComboBox.setValue("Espresso");
        metodoSeleccionado = new MetodoExpresso();

        // Listener para cambio de método
        metodoComboBox.setOnAction(e -> cambiarMetodo());

        lecheCheckBox.setOnAction(e -> calcular());
        azucarCheckBox.setOnAction(e -> calcular());
        wiskyCheckBox.setOnAction(e -> calcular());
        canelaCheckBox.setOnAction(e -> calcular());
        especialRadio.setOnAction(e -> calcular());
        pasillaRadio.setOnAction(e -> calcular());

        calcular();
    }

    private void cambiarMetodo() {
        String metodo = metodoComboBox.getValue();
        switch (metodo) {
            case "Espresso":
                metodoSeleccionado = new MetodoExpresso();
                break;
            case "Filtrado":
                metodoSeleccionado = new MetodoFiltrado();
                break;
            case "Prensa Francesa":
                metodoSeleccionado = new MetodoFrances();
                break;
        }
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

            // Notificar a observadores
            if (cafeteriaObservable != null) {
                cafeteriaObservable.nuevoPedido(
                        "Café " + tipoCafe,
                        cafe.getCosto(),
                        cafe.getDescripcion()
                );
            }

        } catch (Exception e) {
            mostrarError("Error al calcular", "Ocurrió un error durante el cálculo: " + e.getMessage());
        }
    }

    @FXML
    public void mostrarMetodo() {
        String tipoCafe = especialRadio.isSelected() ? "Especial" : "Pasilla";
        String ingredientes = ingredientesLabel.getText();

        String metodoTexto = metodoSeleccionado.prepararCafe(tipoCafe, ingredientes);

        mostrarInformacion("Método de Preparación - " + metodoComboBox.getValue(), metodoTexto);
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
        alert.getDialogPane().setPrefSize(450, 400);
        alert.showAndWait();
    }
}