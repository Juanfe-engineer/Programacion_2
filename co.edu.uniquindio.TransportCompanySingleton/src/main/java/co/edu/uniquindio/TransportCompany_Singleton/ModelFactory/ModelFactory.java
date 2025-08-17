package co.edu.uniquindio.TransportCompany_Singleton.ModelFactory;

import co.edu.uniquindio.TransportCompany_Singleton.Model.Propietario;
import co.edu.uniquindio.TransportCompany_Singleton.Model.TransportCompany;
import co.edu.uniquindio.TransportCompany_Singleton.Model.VehiculoCarga;
import co.edu.uniquindio.TransportCompany_Singleton.Model.VehiculoTransporte;

import javax.swing.*;

public class ModelFactory {
    private static ModelFactory instance;
    private TransportCompany empresa;
    private ModelFactory() {
        empresa = new TransportCompany("La carreta", "900456782");
    }
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    // ============= PUNTO 1 ===============

    public void inicializarDatosPrueba(){
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("ABC345", "Toyota", "Coaster", "Blanco", 25));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("DRH489","Mercedes", "Sprinter", "Gris", 20));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("CKL771", "Chevrolet","NQR", "Azul",30));
        Propietario propetarioBase = new Propietario("Carlos", "12345","Carlos@mail.com", "3009876453");
        VehiculoCarga vehiculoCargaBase = new VehiculoCarga("KSN73F","Volvo","FH","Rojo",4,3);
        VehiculoCarga vehiculoCargaBaseDos = new VehiculoCarga("POH53H", "Foton","Aumark","Negro", 3,3);
        empresa.setVehiculoCarga(vehiculoCargaBase);
        empresa.setVehiculoCarga(vehiculoCargaBaseDos);
        empresa.setPropietario(propetarioBase);
        JOptionPane.showMessageDialog(null, "Datos de prueba inicializados correctamente");
    }

    // ============== PUNTO 2 ================

    public void crearPropietarioVehiculoCarga(){
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
            JOptionPane.showMessageDialog(null, "No hay vehiculo de carga registrado en la empresa.");
        }
    }

    // ============= PUNTO 3 ==================

    public void calcularPasajerosPorVehiculo(){
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
