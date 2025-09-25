package co.edu.uniquindio.cafeteria;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.CafeSimple;
import co.edu.uniquindio.cafeteria.Model.Decorations.AzucarDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.CanelaDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.LecheDecorator;
import co.edu.uniquindio.cafeteria.Model.Decorations.WhiskyDecorator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class CafeApplication extends Application {

    // Componentes de la interfaz
    private CheckBox lecheCheckBox;
    private CheckBox azucarCheckBox;
    private CheckBox wiskyCheckBox;
    private CheckBox canelaCheckBox;

    private RadioButton especialRadio;
    private RadioButton pasillaRadio;

    private Label costoLabel;
    private Label ingredientesLabel;

    private DecimalFormat df = new DecimalFormat("#.#");

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = crearInterfaz();

        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Calculadora de Café - Patrón Decorator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private VBox crearInterfaz() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Cafeteria UQ");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setAlignment(Pos.CENTER);

        VBox ingredientesBox = new VBox(10);
        Label ingredientesTitle = new Label("Ingredientes:");

        HBox ingredientesRow1 = new HBox(20);
        lecheCheckBox = new CheckBox("Leche");
        wiskyCheckBox = new CheckBox("Wisky");
        ingredientesRow1.getChildren().addAll(lecheCheckBox, wiskyCheckBox);

        HBox ingredientesRow2 = new HBox(20);
        azucarCheckBox = new CheckBox("Azúcar");
        canelaCheckBox = new CheckBox("Canela");
        ingredientesRow2.getChildren().addAll(azucarCheckBox, canelaCheckBox);

        ingredientesBox.getChildren().addAll(ingredientesTitle, ingredientesRow1, ingredientesRow2);

        VBox tipoCafeBox = new VBox(8);
        Label tipoCafeTitle = new Label("Tipo café:");

        ToggleGroup tipoCafeGroup = new ToggleGroup();
        especialRadio = new RadioButton("Especial");
        pasillaRadio = new RadioButton("Pasilla");
        especialRadio.setToggleGroup(tipoCafeGroup);
        pasillaRadio.setToggleGroup(tipoCafeGroup);
        especialRadio.setSelected(true);

        HBox radioBox = new HBox(20);
        radioBox.getChildren().addAll(especialRadio, pasillaRadio);

        tipoCafeBox.getChildren().addAll(tipoCafeTitle, radioBox);

        HBox botonesBox = new HBox(15);
        botonesBox.setAlignment(Pos.CENTER);

        Button calcularButton = new Button("Calcular");
        calcularButton.setPrefWidth(100);
        calcularButton.setOnAction(e -> calcular());

        Button metodoButton = new Button("Método preparación");
        metodoButton.setPrefWidth(150);
        metodoButton.setOnAction(e -> mostrarMetodo());

        botonesBox.getChildren().addAll(calcularButton, metodoButton);

        VBox resultadosBox = new VBox(8);

        costoLabel = new Label("Costo: $0.0");

        ingredientesLabel = new Label("Ingredientes: ");
        ingredientesLabel.setWrapText(true);

        resultadosBox.getChildren().addAll(costoLabel, ingredientesLabel);
        root.getChildren().addAll(titulo, ingredientesBox, tipoCafeBox, botonesBox, resultadosBox);

        return root;
    }

    private void calcular() {
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

    private void mostrarMetodo() {
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 300);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}