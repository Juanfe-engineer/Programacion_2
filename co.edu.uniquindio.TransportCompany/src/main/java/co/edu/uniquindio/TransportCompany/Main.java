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
        //calcularPasajerosPorVehiculo(empresa);
    }

    private static void crearPropietarioVehiculoCarga(TransportCompany empresa) {
        JOptionPane.showMessageDialog(null, "Registro de nuevo propietario y vehiculo de carga");

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario: ");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del propietario: ");
        String email = JOptionPane.showInputDialog("Ingrese el email del propietario: ");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del propietario: ");

        Propietario propietario = new Propietario(nombre, identificacion, email, telefono);

        String placa = JOptionPane.showInputDialog("Ingrese la placa del Vehiculo: ");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo: ");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
        String color = JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
        double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga: "));
        int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes: "));

        VehiculoCarga vehiculoCarga = new VehiculoCarga(placa,marca,modelo,color,capacidadCarga,numeroEjes);

        empresa.setPropietario(propietario);
        empresa.setVehiculoCarga(vehiculoCarga);

        JOptionPane.showMessageDialog(null,
                "Propietario y vehiculo de carga creados:\n" + "Propietario: "
                        + propietario.getNombre() + "\n" + "Vehiculo: " + vehiculoCarga.getPlaca());
    }


    private static TransportCompany inicializarDatos() {
        TransportCompany empresa = new TransportCompany("La carreta","900456782");

        // Datos quemados de vehiculos de pasajeros (para el punto 3)

        empresa.getVehiculoTransportes().add(new VehiculoTransporte("ABC345", "Toyota", "Coaster", "Blanco", 25));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("DRH489","Mercedes", "Sprinter", "Gris", 20));
        empresa.getVehiculoTransportes().add(new VehiculoTransporte("CKL771", "Chevrolet","NQR", "Azul",30));

        Propietario propietarioBase = new Propietario("Carlos", "12345","Carlos@mail.com", "3009876453");
        VehiculoCarga vehiculocargaBase = new VehiculoCarga("KSN73F","Volvo","FH","Rojo",12000,3);

        empresa.setPropietario(propietarioBase);
        empresa.setVehiculoCarga(vehiculocargaBase);

        JOptionPane.showMessageDialog(null,"Datos de prueba inicializados correctamente");
        return empresa;


    }







}