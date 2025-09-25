package co.edu.uniquindio.TransportCompany_Singleton.Model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class VehiculoCargaRepositorio {

    public String buscarVehiculoCarga(LinkedList<Vehiculo> vehiculos, String placa) {
        String resultado = "";

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof VehiculoCarga && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                resultado = vehiculo.toString();
                break;
            }
        }
        return resultado;
    }

    public boolean agregarVehiculoCarga(LinkedList<Vehiculo> vehiculos,String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        Vehiculo vehiculo = obtenerVehiculoCarga(placa);
        if (vehiculo == null) {
            VehiculoCarga vehiculoCarga = new VehiculoCarga(placa, marca, modelo, color, capacidadCarga, numeroEjes);
            vehiculos.add(vehiculoCarga);
            return true;
        } else {
            return false;
        }
    }

    public VehiculoCarga obtenerVehiculoCarga(LinkedList<Vehiculo> vehiculos ,String placa) {
        VehiculoCarga vehiculoEncontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof VehiculoCarga && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = (VehiculoCarga) vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }

    public boolean eliminarVehiculoCarga(LinkedList<Vehiculo> vehiculos,String placa) {
        VehiculoCarga vehiculo = obtenerVehiculoCarga(vehiculos, placa);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarVehiculoCarga(LinkedList<Vehiculo> vehiculos ,String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        VehiculoCarga vehiculo = obtenerVehiculoCarga(vehiculos, placa);
        if (vehiculo != null) {
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setColor(color);
            vehiculo.setCapacidadCarga(capacidadCarga);
            vehiculo.setNumeroEjes(numeroEjes);
            return true;
        } else {
            return false;
        }
    }
}
