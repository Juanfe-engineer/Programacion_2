package co.edu.uniquindio.TransportCompany_Singleton.Model;

public class VehiculoTransporteRepositorio {

    public String buscarVehiculoTransporte(String placa) {
        String resultado = "";
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo instanceof VehiculoTransporte && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                resultado = vehiculo.toString();
                break;
            }
        }
        return resultado;
    }

    public boolean agregarVehiculoTransporte(String placa, String marca, String modelo, String color, int maxPasajeros) {
        Vehiculo vehiculo = obtenerVehiculo(placa);
        if (vehiculo == null) {
            VehiculoTransporte vehiculoTransporte = new VehiculoTransporte(placa, marca, modelo, color, maxPasajeros);
            getVehiculos().add(vehiculoTransporte);
            return true;
        } else {
            return false;
        }
    }

    public VehiculoTransporte obtenerVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculoEncontrado = null;
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo instanceof VehiculoTransporte && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = (VehiculoTransporte) vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }

    public boolean eliminarVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculo = obtenerVehiculoTransporte(placa);
        if (vehiculo != null) {
            getVehiculos().remove(vehiculo);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarVehiculoTransporte(String placa, String marca, String modelo, String color, int maxPasajeros, int usuariosTransportados) {
        VehiculoTransporte vehiculo = obtenerVehiculoTransporte(placa);
        if (vehiculo != null) {
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setColor(color);
            vehiculo.setMaximoPasajeros(maxPasajeros);
            vehiculo.setUsuariosTransportados(usuariosTransportados);
            return true;
        } else {
            return false;
        }
    }
}
