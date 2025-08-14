package co.edu.uniquindio.TransportCompany.Model;

public class VehiculoTransporte extends Vehiculo {
    private int maxPasajeros;

    public VehiculoTransporte(String placa, String marca, String modelo, String color,int maxPasajeros) {
        super(placa,marca,modelo,color);
        this.maxPasajeros = maxPasajeros;
    }
    public int getMaxPasajeros() {
        return maxPasajeros;
    }
    public void setMaximoPasajeros( int maxPasajeros ) {
        this.maxPasajeros = maxPasajeros;
    }
}
