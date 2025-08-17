package co.edu.uniquindio.TransportCompany_Singleton;

import co.edu.uniquindio.TransportCompany_Singleton.ModelFactory.ModelFactory;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        modelFactory.inicializarDatosPrueba();
        modelFactory.crearPropietarioVehiculoCarga();
        modelFactory.calcularPasajerosPorVehiculo();
    }
}