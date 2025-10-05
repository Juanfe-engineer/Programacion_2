package co.edu.uniquindio.cafeteria.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VideoController implements Initializable {

    @FXML private TextField archivoTextField;
    @FXML private Button cargarButton;
    @FXML private Button reproducirButton;
    @FXML private Label reproduciendoLabel;

    private File archivoSeleccionado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reproduciendoLabel.setText("Reproduciendo:");
        archivoTextField.setEditable(false);
    }

    @FXML
    public void cargarArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo de video");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Video", "*.mp4", "*.avi", "*.mkv", "*.mov"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );

        archivoSeleccionado = fileChooser.showOpenDialog(cargarButton.getScene().getWindow());

        if (archivoSeleccionado != null) {
            archivoTextField.setText(archivoSeleccionado.getName());
            reproduciendoLabel.setText("Reproduciendo:");
        }
    }

    @FXML
    public void reproducirVideo() {
        if (archivoSeleccionado != null) {
            String rutaCompleta = archivoSeleccionado.getAbsolutePath();
            reproduciendoLabel.setText("Reproduciendo: " + rutaCompleta);

            mostrarInformacion("Reproducción Iniciada",
                    "Reproduciendo: " + archivoSeleccionado.getName() + "\n\n" +
                            "Ruta: " + rutaCompleta);
        } else {
            mostrarAdvertencia("Sin archivo",
                    "Por favor, primero cargue un archivo de video usando el botón 'Cargar archivo'.");
        }
    }

    private void mostrarInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
