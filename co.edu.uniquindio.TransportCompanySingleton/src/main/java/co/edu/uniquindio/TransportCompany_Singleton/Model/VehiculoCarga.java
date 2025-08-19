package co.edu.uniquindio.TransportCompany_Singleton.Model;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        super(placa, marca, modelo, color);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public int getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "VehiculoCarga{" +
                "placa='" + getPlaca() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", color='" + getColor() + '\'' +
                ", pesoMaximo=" + capacidadCarga +
                ", numeroEjes=" + numeroEjes +
                '}';
    }
}
