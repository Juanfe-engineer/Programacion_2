package co.edu.uniquindio.TransportCompany;

import co.edu.uniquindio.TransportCompany.Model.Propietario;
import co.edu.uniquindio.TransportCompany.Model.TransportCompany;
import co.edu.uniquindio.TransportCompany.Model.VehiculoCarga;
import co.edu.uniquindio.TransportCompany.Model.VehiculoTransporte;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        TransportCompany empresa = inicializarDatos();
        crearPropietarioVehiculoCarga(empresa);
        calcularPasajerosPorVehiculo(empresa);
    }


    // PUNTO 1
    private static TransportCompany inicializarDatos() {
        TransportCompany empresa = new TransportCompany("La carreta","900456782");

        // Datos quemados de vehiculos de pasajeros (para el punto 3)

        empresa.getVehiculoTransportes().add(new VehiculoTransporte("ABC345", "Toyota", "Coaster", "Blanco", 25));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("DRH489","Mercedes", "Sprinter", "Gris", 20));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("CKL771", "Chevrolet","NQR", "Azul",30));

        Propietario propietarioBase = new Propietario("Carlos", "12345","Carlos@mail.com", "3009876453");
        VehiculoCarga vehiculocargaBase = new VehiculoCarga("KSN73F","Volvo","FH","Rojo",4,3);
        VehiculoCarga  vehiculoCargaBaseDos = new VehiculoCarga("POH53H", "Foton","Aumark","Negro", 3,3);

        empresa.setPropietario(propietarioBase);
        empresa.setVehiculoCarga(vehiculocargaBase);
        empresa.setVehiculoCarga(vehiculoCargaBaseDos);


        JOptionPane.showMessageDialog(null,"Datos de prueba inicializados correctamente");
        return empresa;
    }


    // PUNTO 2
    private static void crearPropietarioVehiculoCarga(TransportCompany empresa) {
        JOptionPane.showMessageDialog(null, "Registro de nuevo propietario y vehiculo de carga");

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario: ");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del propietario: ");
        String email = JOptionPane.showInputDialog("Ingrese el email del propietario: ");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del propietario: ");

        Propietario propietario = new Propietario(nombre, identificacion, email, telefono);

        if(empresa.getVehiculoCarga() != null) {
            JOptionPane.showMessageDialog(null, "Se asigno el vehiculo de carga con placa: " +
                    empresa.getVehiculoCarga().getPlaca() + " al propietario " + nombre);
            empresa.setPropietario(propietario);
        } else {
            JOptionPane.showMessageDialog(null, " No hay vehiculo de carga registrado en la empresa.");
        }
    }


    // PUNTO 3

    private static void calcularPasajerosPorVehiculo(TransportCompany empresa) {

        String mensaje = "Vehículos disponibles:\n" +
                "• ABC345 - Toyota Coaster\n" +
                "• DRH489 - Mercedes Sprinter\n" +
                "• CKL771 - Chevrolet NQR\n\n" +
                "Ingrese la placa a consultar:";

        String placaVehiculo = JOptionPane.showInputDialog(mensaje);


        VehiculoTransporte vehiculoencontrado = null;
        for(VehiculoTransporte vehiculo : empresa.getVehiculoTransportes()){
            if(vehiculo.getPlaca().equalsIgnoreCase(placaVehiculo)){
                vehiculoencontrado = vehiculo;
                break;
            }
        }

        if (vehiculoencontrado != null) {
            String viajes = JOptionPane.showInputDialog(
                    "Vehiculo: " + vehiculoencontrado.getPlaca() + " Capacidad: " +
                            vehiculoencontrado.getMaxPasajeros() + "\n" +
                            "¿Cuantos viajes realizo en el dia?");

            int numeroViajes = Integer.parseInt(viajes);
            int totalPasajeros = 0;

            for(int i = 1 ; i <= numeroViajes; i++){
                String pasajeros = JOptionPane.showInputDialog(
                        "Viaje " + i + " de " + numeroViajes + "\n" +
                                "¿Cuantos pasajeros se transportaron?");

                int pasajerosViajes = Integer.parseInt(pasajeros);
                totalPasajeros += pasajerosViajes;
            }

            String reporte = "=== REPORTE DE PASAJEROS ===\n\n" +
                    "PROPIETARIO: " + empresa.getPropietario().getNombre() + "\n" +
                    "VEHÍCULO: " + vehiculoencontrado.getPlaca() + "\n" +
                    "MARCA: " + vehiculoencontrado.getMarca() + " " + vehiculoencontrado.getModelo() + "\n" +
                    "CAPACIDAD: " + vehiculoencontrado.getMaxPasajeros() + " pasajeros\n\n" +
                    "VIAJES REALIZADOS: " + numeroViajes + "\n" +
                    "TOTAL PASAJEROS TRANSPORTADOS: " + totalPasajeros + "\n" +
                    "PROMEDIO POR VIAJE: " + (totalPasajeros / numeroViajes);

            JOptionPane.showMessageDialog(null, reporte, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } else{
            JOptionPane.showMessageDialog(null,
                    "No se encontró vehículo con placa: " + placaVehiculo + "\n\n" +
                            "Placas disponibles: ABC345, DRH489, CKL771",
                    "Vehículo No Encontrado", JOptionPane.ERROR_MESSAGE);
        }

    }

}