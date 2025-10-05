package co.edu.uniquindio.cafeteria.Model.Observer;

public interface Observable {
    void agregarObservador(Observer observer);
    void eliminarObservador(Observer observer);
    void notificarObservadores();
}
