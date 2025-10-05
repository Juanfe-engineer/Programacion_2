package co.edu.uniquindio.cafeteria.Controller;

import co.edu.uniquindio.cafeteria.Model.Observer.Observer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ObserverVentana1Controller implements Initializable, Observer {

    @FXML private Label pedidoLabel;
    @FXML private Label costoLabel;
    @FXML private TextArea historialTextArea;

    private DecimalFormat df = new DecimalFormat("#.#");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pedidoLabel.setText("Esperando pedido...");
        costoLabel.setText("Costo: $0.0");
        historialTextArea.setEditable(false);
        historialTextArea.setText("=== HISTORIAL DE PEDIDOS ===\n\n");
    }

    @Override
    public void actualizar(String mensaje, double costo, String ingredientes) {
        Platform.runLater(() -> {
            pedidoLabel.setText("Último pedido: " + mensaje);
            costoLabel.setText("Costo: $" + df.format(costo));

            String hora = LocalTime.now().format(timeFormatter);
            String registro = String.format("[%s] %s - $%s\n   %s\n\n",
                    hora, mensaje, df.format(costo), ingredientes);

            historialTextArea.appendText(registro);
        });
    }
}