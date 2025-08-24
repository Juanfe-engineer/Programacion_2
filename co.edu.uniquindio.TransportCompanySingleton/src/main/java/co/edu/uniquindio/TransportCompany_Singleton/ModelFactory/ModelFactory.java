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

        Propietario prop1 = new Propietario("Carlos Mendez", "12345","carlos@gmail.com","3009876453",38,58.7);
        Propietario prop2 = new Propietario("Ana García", "67890", "ana@mail.com", "3001234567", 45,65.6);
        Propietario prop3 = new Propietario("Luis Torres", "11111", "luis@mail.com", "3007891234", 35,78.9);

        prop1.getVehiculos().add(vc1);
        prop2.getVehiculos().add(vc2);
        prop3.getVehiculos().add(vt1);

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
        try {
            JOptionPane.showMessageDialog(null, "Registro de nuevo propietario y vehiculo de carga");

            // Datos del propietario

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");
            if (identificacion == null || identificacion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String email = JOptionPane.showInputDialog("Ingrese el email del propietario:");
            if (email == null || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del propietario:");
            if (telefono == null || telefono.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String edadStr = JOptionPane.showInputDialog("Ingrese la edad del propietario:");
            if (edadStr == null || edadStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }

            // Datos Vehiculo

            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga:");
            if (placa == null || placa.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
            if (marca == null || marca.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
            if (modelo == null || modelo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
            if (color == null || color.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String pesoStr = JOptionPane.showInputDialog("Ingrese el peso máximo (toneladas):");
            if (pesoStr == null || pesoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            String ejesStr = JOptionPane.showInputDialog("Ingrese el número de ejes:");
            if (ejesStr == null || ejesStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }

            int edad = Integer.parseInt(edadStr);
            int ejes = Integer.parseInt(ejesStr);
            double peso = Double.parseDouble(pesoStr);

            Propietario nuevoPropietario = new Propietario(nombre, identificacion, email, telefono, edad, peso);
            VehiculoCarga nuevoVehiculo = new VehiculoCarga(placa, marca, modelo, color, peso, ejes);

            nuevoPropietario.getVehiculos().add(nuevoVehiculo);

            empresa.getPropietarios().add(nuevoPropietario);
            empresa.getVehiculos().add(nuevoVehiculo);

            JOptionPane.showMessageDialog(null,
                    "Propietario y vehículo registrados exitosamente:\n" +
                            "Propietario: " + nombre + "\n" +
                            "Vehículo: " + marca + " " + modelo + " (Placa: " + placa + ")");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Verifique que los números estén correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // ============= PUNTO 3 ==================

    public void calcularPasajerosPorVehiculo() {
        try {
            String mensaje = "Vehículos de transporte disponibles:\n\n";
            boolean hayVehiculos = false;

            for (Vehiculo v : empresa.getVehiculos()) {
                if (v instanceof VehiculoTransporte) {
                    mensaje += "• " + v.getPlaca() + " - " + v.getMarca() + " " + v.getModelo() + "\n";
                    hayVehiculos = true;
                }
            }
            if (!hayVehiculos) {
                JOptionPane.showMessageDialog(null, "No hay vehículos de transporte registrados");
                return;
            }
            mensaje += "\nIngrese la placa del vehículo:";
            String placaIngresada = JOptionPane.showInputDialog(mensaje);

            if (placaIngresada == null || placaIngresada.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            VehiculoTransporte vehiculoEncontrado = null;
            for (Vehiculo v : empresa.getVehiculos()) {
                if (v instanceof VehiculoTransporte && v.getPlaca().equalsIgnoreCase(placaIngresada)) {
                    vehiculoEncontrado = (VehiculoTransporte) v;
                    break;
                }
            }
            if (vehiculoEncontrado != null) {
                String viajesStr = JOptionPane.showInputDialog(
                        "Vehículo: " + vehiculoEncontrado.getPlaca() +
                                "\nCapacidad: " + vehiculoEncontrado.getMaxPasajeros() + " pasajeros" +
                                "\n\n¿Cuántos viajes realizó en el día?");

                if (viajesStr == null || viajesStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                    return;
                }
                int numeroViajes = Integer.parseInt(viajesStr);
                int totalPasajeros = numeroViajes * vehiculoEncontrado.getMaxPasajeros();
                vehiculoEncontrado.setUsuariosTransportados(totalPasajeros);

                // Mostrar reporte
                String reporte = "=== REPORTE DE PASAJEROS ===\n\n" +
                        "VEHÍCULO: " + vehiculoEncontrado.getPlaca() + "\n" +
                        "MARCA: " + vehiculoEncontrado.getMarca() + " " + vehiculoEncontrado.getModelo() + "\n" +
                        "CAPACIDAD: " + vehiculoEncontrado.getMaxPasajeros() + " pasajeros\n\n" +
                        "VIAJES REALIZADOS: " + numeroViajes + "\n" +
                        "TOTAL PASAJEROS TRANSPORTADOS: " + totalPasajeros + "\n" +
                        "PROMEDIO POR VIAJE: " + vehiculoEncontrado.getMaxPasajeros();

                JOptionPane.showMessageDialog(null, reporte, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un vehículo de transporte con esa placa.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    // ======================= PUNTO 4 ===============================

    public void obtenerPropietariosPorPeso() {
        try {
            String input = JOptionPane.showInputDialog("Ingrese el valor de peso mínimo:");
            if (input == null) {
                return;
            }
            double pesoMinimo = Double.parseDouble(input);

            List<Propietario> lista = empresa.getPropietarios();
            StringBuilder resultado = new StringBuilder("Propietarios con peso mayor a " + pesoMinimo + " kg:\n\n");

            boolean encontrado = false;
            for (Propietario p : lista) {
                if (p.getPeso() > pesoMinimo) {
                    resultado.append("Nombre: ").append(p.getNombre())
                            .append(" | ID: ").append(p.getIdentificacion())
                            .append(" | Peso: ").append(p.getPeso()).append(" kg\n");
                    encontrado = true;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null,
                        "No se encontraron propietarios con peso mayor a " + pesoMinimo + " kg.");
            } else {
                JOptionPane.showMessageDialog(null, resultado.toString());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido para el peso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========================= PUNTO 5 =============================

    public void obtenerUsuariosPorVehiculo(){
        try {
            String mensaje = "Vehículos de transporte disponibles:\n\n";
            boolean hayVehiculos = false;

            for(Vehiculo v: empresa.getVehiculos()){
                if(v instanceof VehiculoTransporte){
                    mensaje += "• " + v.getPlaca() + " - " + v.getMarca() + " " + v.getModelo() + "\n";
                    hayVehiculos = true;
                }
            }
            if (!hayVehiculos) {
                JOptionPane.showMessageDialog(null, "No hay vehículos de transporte registrados");
                return;
            }

            mensaje += "\nIngrese la placa del vehículo:";
            String placa = JOptionPane.showInputDialog(mensaje);

            if (placa == null || placa.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            // Buscar vehículo
            boolean encontrado = false;
            for(Vehiculo v: empresa.getVehiculos()){
                if(v instanceof VehiculoTransporte && v.getPlaca().equalsIgnoreCase(placa)){
                    VehiculoTransporte vt = (VehiculoTransporte) v;

                    String resultado = "=== USUARIOS TRANSPORTADOS EN VEHÍCULO " + placa + " ===\n\n" +
                            "Vehículo: " + vt.getMarca() + " " + vt.getModelo() + "\n" +
                            "Placa: " + vt.getPlaca() + "\n" +
                            "Capacidad máxima: " + vt.getMaxPasajeros() + " pasajeros\n" +
                            "Total usuarios transportados: " + vt.getUsuariosTransportados();

                    JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró un vehículo de transporte con la placa: " + placa, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // ========================= PUNTO 6 ==========================

    public void obtenerPropietariosMayoresDe40(){
        try {
            List<Propietario> mayores = new ArrayList<>();

            for(Propietario prop: empresa.getPropietarios()){
                if(prop.getEdad() > 40){
                    mayores.add(prop);
                }
            }

            String resultado = "=== PROPIETARIOS MAYORES DE 40 AÑOS ===\n\n";
            resultado += "Número de propietarios mayores de 40 años: " + mayores.size() + "\n\n";

            if(mayores.isEmpty()){
                resultado += "No hay propietarios mayores de 40 años registrados.";
            } else {
                resultado += "Lista de propietarios:\n";
                for(Propietario prop: mayores){
                    resultado += "• " + prop.getNombre() + " (Edad: " + prop.getEdad() + " años)\n";
                }
            }
            JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    // CRUDS

    // Propietario

    public String buscarPropietarioNombre(String nombre){
        return empresa.buscarPropietarioNombre(nombre);
    }

    public boolean agregarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        return empresa.agregarPropietario(nombre, identificacion, email, telefono, edad, peso);
    }

    public Propietario obtenerPropietario(String identificacion) {
        return empresa.obtenerPropietario(identificacion);
    }

    public boolean eliminarPropietario(String identificacion) {
        return empresa.eliminarPropietario(identificacion);
    }

    public boolean actualizarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        return empresa.actualizarPropietario(nombre, identificacion, email, telefono, edad, peso);
    }


    //  Vehiculo Carga

    public String buscarVehiculoCarga(String placa) {
        return empresa.buscarVehiculoCarga(placa);
    }

    public boolean agregarVehiculoCarga(String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        return empresa.agregarVehiculoCarga(placa, marca, modelo, color, capacidadCarga, numeroEjes);
    }

    public VehiculoCarga obtenerVehiculoCarga(String placa) {
        return empresa.obtenerVehiculoCarga(placa);
    }

    public boolean eliminarVehiculoCarga(String placa) {
        return empresa.eliminarVehiculoCarga(placa);
    }

    public boolean actualizarVehiculoCarga(String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        return empresa.actualizarVehiculoCarga(placa, marca, modelo, color, capacidadCarga, numeroEjes);
    }


    // Vehiculo Transporte

    public String buscarVehiculoTransporte(String placa) {
        return empresa.buscarVehiculoTransporte(placa);
    }

    public boolean agregarVehiculoTransporte(String placa, String marca, String modelo, String color, int maxPasajeros) {
        return empresa.agregarVehiculoTransporte(placa, marca, modelo, color, maxPasajeros);
    }

    public VehiculoTransporte obtenerVehiculoTransporte(String placa) {
        return empresa.obtenerVehiculoTransporte(placa);
    }

    public boolean eliminarVehiculoTransporte(String placa) {
        return empresa.eliminarVehiculoTransporte(placa);
    }

    public boolean actualizarVehiculoTransporte(String placa, String marca, String modelo, String color, int maxPasajeros, int usuariosTransportados) {
        return empresa.actualizarVehiculoTransporte(placa, marca, modelo, color, maxPasajeros, usuariosTransportados);
    }

    // Vehiculo General

    public Vehiculo obtenerVehiculo(String placa) {
        return empresa.obtenerVehiculo(placa);
    }

















}
