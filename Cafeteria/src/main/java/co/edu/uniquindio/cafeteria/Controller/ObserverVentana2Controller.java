package co.edu.uniquindio.cafeteria.Controller;

import co.edu.uniquindio.cafeteria.Model.Observer.Observer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class ObserverVentana2Controller implements Initializable, Observer {

    @FXML private Label estadoLabel;
    @FXML private Label totalVentasLabel;
    @FXML private ListView<String> pedidosListView;

    private DecimalFormat df = new DecimalFormat("#.#");
    private double totalVentas = 0.0;
    private int cantidadPedidos = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        estadoLabel.setText("Estado: Esperando pedidos");
        totalVentasLabel.setText("Total ventas: $0.0 | Pedidos: 0");
    }

    @Override
    public void actualizar(String mensaje, double costo, String ingredientes) {
        Platform.runLater(() -> {
            cantidadPedidos++;
            totalVentas += costo;

            estadoLabel.setText("Estado: ¡Nuevo pedido recibido!");
            totalVentasLabel.setText(String.format("Total ventas: $%s | Pedidos: %d",
                    df.format(totalVentas), cantidadPedidos));

            String item = String.format("Pedido #%d: %s ($%s)",
                    cantidadPedidos, mensaje, df.format(costo));
            pedidosListView.getItems().add(0, item);
        });
    }
}