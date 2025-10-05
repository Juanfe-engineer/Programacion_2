package co.edu.uniquindio.cafeteria.Model.Observer;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaObservable implements Observable{
    private List<Observer> observadores = new ArrayList<>();
    private String ultimoPedido;
    private double ultimoCosto;
    private String ultimosIngredientes;

    @Override
    public void agregarObservador(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void eliminarObservador(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificarObservadores() {
        for (Observer observer : observadores) {
            observer.actualizar(ultimoPedido, ultimoCosto, ultimosIngredientes);
        }
    }

    public void nuevoPedido(String pedido, double costo, String ingredientes) {
        this.ultimoPedido = pedido;
        this.ultimoCosto = costo;
        this.ultimosIngredientes = ingredientes;
        notificarObservadores();
    }
}
