package co.edu.uniquindio.TransportCompany_Singleton.Model;

public class VehiculoTransporte extends Vehiculo{
    private int maxPasajeros;
    private int usuariosTransportados;


    public VehiculoTransporte(String placa, String marca, String modelo, String color,int maxPasajeros) {
        super(placa,marca,modelo,color);
        this.maxPasajeros = maxPasajeros;
        this.usuariosTransportados = 0;
    }
    public int getMaxPasajeros() {
        return maxPasajeros;
    }
    public void setMaximoPasajeros( int maxPasajeros ) {
        this.maxPasajeros = maxPasajeros;
    }
    public int getUsuariosTransportados() {
        return usuariosTransportados;
    }
    public void setUsuariosTransportados( int usuariosTransportados ) {
        this.usuariosTransportados = usuariosTransportados;
    }


    @Override
    public String toString() {
        return "VehiculoTransporte{" +
                "placa='" + getPlaca() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", color='" + getColor() + '\'' +
                ", maxPasajeros=" + maxPasajeros +
                ", usuariosTransportados=" + usuariosTransportados +
                '}';
    }
}
