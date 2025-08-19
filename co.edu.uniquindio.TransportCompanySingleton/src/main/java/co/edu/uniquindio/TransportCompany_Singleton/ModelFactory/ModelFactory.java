package co.edu.uniquindio.TransportCompany_Singleton.ModelFactory;

import co.edu.uniquindio.TransportCompany_Singleton.Model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        VehiculoTransporte vt1 = new VehiculoTransporte("ABC345", "Toyota", "Coaster", "Blanco", 25);
        VehiculoTransporte vt2 = new VehiculoTransporte("DRH489", "Mercedes", "Sprinter", "Gris", 20);
        VehiculoTransporte vt3 = new VehiculoTransporte("CKL771", "Chevrolet", "NQR", "Azul", 30);
        VehiculoCarga vc1 = new VehiculoCarga("KSN73F", "Volvo", "FH", "Rojo", 4, 3);
        VehiculoCarga vc2 = new VehiculoCarga("POH53H", "Foton", "Aumark", "Negro", 3, 3);
        empresa.getVehiculos().add(vt1);
        empresa.getVehiculos().add(vt2);
        empresa.getVehiculos().add(vt3);
        empresa.getVehiculos().add(vc1);
        empresa.getVehiculos().add(vc2);
        Propietario prop1 = new Propietario("Carlos Mendez", "12345","carlos@gmail.com","3009876453",38);
        prop1.setVehiculo(vc1); // Carlos tiene un vehiculo de carga
        Propietario prop2 = new Propietario("Ana García", "67890", "ana@mail.com", "3001234567", 45);
        prop2.setVehiculo(vc2); // Ana tiene un vehículo de carga
        Propietario prop3 = new Propietario("Luis Torres", "11111", "luis@mail.com", "3007891234", 35);
        prop3.setVehiculo(vt1); // Luis tiene un vehículo de transporte
        empresa.getPropietarios().add(prop1);
        empresa.getPropietarios().add(prop2);
        empresa.getPropietarios().add(prop3);
        vt1.setUsuariosTransportados(150); // 6 viajes con 25 pasajeros cada uno
        vt2.setUsuariosTransportados(80);  // 4 viajes con 20 pasajeros cada uno
        vt3.setUsuariosTransportados(120); // 4 viajes con 30 pasajeros cada uno
        JOptionPane.showMessageDialog(null, "Datos de prueba inicializados correctamente");
    }

    // ============== PUNTO 2 ================

    public void crearPropietarioVehiculoCarga(){
        JOptionPane.showMessageDialog(null, "Registro de nuevo propietario y vehiculo de carga");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario: ");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del propietario: ");
        String email = JOptionPane.showInputDialog("Ingrese el email del propietario: ");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del propietario: ");
        String edadStr = JOptionPane.showInputDialog("Ingrese la edad del propietario: ");

        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
        String pesoStr = JOptionPane.showInputDialog("Ingrese el peso máximo (toneladas):");
        String ejesStr = JOptionPane.showInputDialog("Ingrese el número de ejes:");

        try {
            int ejes = Integer.parseInt(ejesStr);
            double peso = Double.parseDouble(pesoStr);
            int edad = Integer.parseInt(edadStr);
            Propietario nuevoPropietario = new Propietario(nombre, identificacion, email, telefono, edad);
            VehiculoCarga nuevoVehiculo = new VehiculoCarga(placa, marca, modelo, color, peso, ejes);
            nuevoPropietario.setVehiculo(nuevoVehiculo);
            empresa.getPropietarios().add(nuevoPropietario);
            empresa.getVehiculos().add(nuevoVehiculo);
            JOptionPane.showMessageDialog(null,
                    "Propietario y vehiculo registrados exitosamente:\n" +
                    "Propietario: " + nombre + "\n" +
                    "Vehiculo: " + marca + " " + modelo + " (Placa: " + placa + ")");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: verifique que los numeros esten correctos.");
        }
    }

    // ============= PUNTO 3 ==================

    public void calcularPasajerosPorVehiculo() {

        String mensaje = "Vehículos de transporte disponibles:\n";
        for (Vehiculo v : empresa.getVehiculos()) {
            if (v instanceof VehiculoTransporte) {
                mensaje += "• " + v.getPlaca() + " - " + v.getMarca() + " " + v.getModelo() + "\n";
            }
        }
        mensaje += "\nIngrese la placa del vehículo:";

        String placaIngresada = JOptionPane.showInputDialog(mensaje);

        // Buscar el vehículo
        VehiculoTransporte vehiculoEncontrado = null;
        for (Vehiculo v : empresa.getVehiculos()) {
            if (v instanceof VehiculoTransporte && v.getPlaca().equalsIgnoreCase(placaIngresada)) {
                vehiculoEncontrado = (VehiculoTransporte) v;
                break;
            }
        }
        if (vehiculoEncontrado != null) {
            try {
                // Pedimos cuántos viajes hizo
                int numeroViajes = Integer.parseInt(JOptionPane.showInputDialog(
                        "Vehículo: " + vehiculoEncontrado.getPlaca() +
                                "\nCapacidad: " + vehiculoEncontrado.getMaxPasajeros() + " pasajeros" +
                                "\n\n¿Cuántos viajes realizó en el día?"));

                int totalPasajeros = numeroViajes * vehiculoEncontrado.getMaxPasajeros();
                vehiculoEncontrado.setUsuariosTransportados(totalPasajeros);

                // Reporte
                String reporte = "=== REPORTE DE PASAJEROS ===\n\n" +
                        "VEHÍCULO: " + vehiculoEncontrado.getPlaca() + "\n" +
                        "MARCA: " + vehiculoEncontrado.getMarca() + " " + vehiculoEncontrado.getModelo() + "\n" +
                        "CAPACIDAD: " + vehiculoEncontrado.getMaxPasajeros() + " pasajeros\n\n" +
                        "VIAJES REALIZADOS: " + numeroViajes + "\n" +
                        "TOTAL PASAJEROS TRANSPORTADOS: " + totalPasajeros + "\n" +
                        "PROMEDIO POR VIAJE: " + vehiculoEncontrado.getMaxPasajeros();

                JOptionPane.showMessageDialog(null, reporte, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se encontró un vehículo de transporte con esa placa.");
        }
    }



    // ======================= PUNTO 4 ===============================

    public void obtenerPropietariosPorPeso(){

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el peso mínimo en toneladas: ");
        double pesoMinimo = sc.nextDouble();
        System.out.println("\n == Propietarios que superan " + pesoMinimo + " Toneladas ==");
        List<Propietario> encontrados = new ArrayList<>();
        for(Propietario prop: empresa.getPropietarios()){
            if(prop.getVehiculo() instanceof VehiculoCarga){
                VehiculoCarga vc = (VehiculoCarga) prop.getVehiculo();
                if (vc.getCapacidadCarga() >= pesoMinimo){
                    encontrados.add(prop);
                }
            }
        }
        if (encontrados.isEmpty()){
            System.out.println("No se encontraron propietarios con vehiculos que superen " + pesoMinimo + " Toneladas.");
        } else {
            System.out.println("Propietarios encontrados: " + encontrados.size());
            for (Propietario prop: encontrados){
                VehiculoCarga vc = (VehiculoCarga) prop.getVehiculo();
                System.out.println("- " + prop.getNombre() + " (Peso maximo: " + vc.getCapacidadCarga() + "toneladas)");
            }
        }
    }

    // ========================= PUNTO 5 =============================

    public void obtenerUsuariosPorVehiculo (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa = sc.nextLine();
        System.out.println("\n== Usuarios transportados en vehiculo " + placa + " ==");
        for(Vehiculo v: empresa.getVehiculos()){
            if(v instanceof VehiculoTransporte vt && v.getPlaca().equalsIgnoreCase(placa)){
                System.out.println("Vehículo: " + vt.getMarca() + " " + vt.getModelo());
                System.out.println("Placa: " + vt.getPlaca());
                System.out.println("Total usuarios transportados: " + vt.getUsuariosTransportados());
                return;
            }
        }
        System.out.println("No se encontro un vehiculo de transporte con la placa: " + placa);
    }

    // ========================= PUNTO 6 ==========================

    public void obtenerPropietariosMayoresDe40(){
        System.out.println("\n=== PROPIETARIOS MAYORES DE 40 AÑOS ===");
        List<Propietario> mayores = new ArrayList<>();
        for(Propietario prop: empresa.getPropietarios()){
            if(prop.getEdad() > 40){
                mayores.add(prop);
            }
        }
        System.out.println("Numero de propietarios mayores de 40 años: " + mayores.size());
        if(mayores.isEmpty()){
            System.out.println("Lista de propietarios:");
            for(Propietario prop: mayores){
                System.out.println("- " + prop.getNombre() + " (Edad: " + prop.getEdad() + " años)");
            }
        }
    }

}
