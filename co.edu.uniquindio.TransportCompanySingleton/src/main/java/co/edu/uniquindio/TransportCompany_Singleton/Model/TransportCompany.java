package co.edu.uniquindio.TransportCompany_Singleton.Model;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String nombre;
    private String nit;
    private List<Propietario> propietarios;
    private List<Vehiculo> vehiculos;

    public TransportCompany(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.propietarios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit){
        this.nit = nit;
    }
    public List<Propietario> getPropietarios() {
        return propietarios;
    }
    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }



    // CRUD PROPIETARIO

    public String buscarPropietarioNombre(String nombre) {
        String resultado = "";
        for (Propietario propietario: getPropietarios()) {
            if(propietario.getNombre().equalsIgnoreCase(nombre)){
                resultado = propietario.toString();
                break;
            }
        }

        return resultado;
    }


    public boolean agregarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario == null){
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setIdentificacion(identificacion);
            propietario.setEmail(email);
            propietario.setTelefono(telefono);
            propietario.setEdad(edad);
            propietario.setPeso(peso);

            getPropietarios().add(propietario);

            return true;
        }else{
            return false;
        }
    }


    public Propietario obtenerPropietario(String identificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario: getPropietarios()) {
            if(propietario.getIdentificacion().equalsIgnoreCase(identificacion)){
                propietarioEncontrado = propietario;
                break;
            }
        }

        return propietarioEncontrado;
    }


    public boolean eliminarPropietario(String identificacion) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario != null){
            getPropietarios().remove(propietario);
            return true;
        }else{
            return false;
        }
    }


    public boolean actualizarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario != null){
            propietario.setNombre(nombre);
            propietario.setIdentificacion(identificacion);
            propietario.setEmail(email);
            propietario.setTelefono(telefono);
            propietario.setEdad(edad);
            propietario.setPeso(peso);

            return true;
        }else{
            return false;
        }
    }


    // Vehiculo

    public Vehiculo obtenerVehiculo(String placa) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }



    // CRUD VEHICULO CARGA

    public String buscarVehiculoCarga(String placa) {
        String resultado = "";
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo instanceof VehiculoCarga && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                resultado = vehiculo.toString();
                break;
            }
        }
        return resultado;
    }

    public boolean agregarVehiculoCarga(String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        Vehiculo vehiculo = obtenerVehiculo(placa);
        if (vehiculo == null) {
            VehiculoCarga vehiculoCarga = new VehiculoCarga(placa, marca, modelo, color, capacidadCarga, numeroEjes);
            getVehiculos().add(vehiculoCarga);
            return true;
        } else {
            return false;
        }
    }

    public VehiculoCarga obtenerVehiculoCarga(String placa) {
        VehiculoCarga vehiculoEncontrado = null;
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo instanceof VehiculoCarga && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = (VehiculoCarga) vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }

    public boolean eliminarVehiculoCarga(String placa) {
        VehiculoCarga vehiculo = obtenerVehiculoCarga(placa);
        if (vehiculo != null) {
            getVehiculos().remove(vehiculo);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarVehiculoCarga(String placa, String marca, String modelo, String color, double capacidadCarga, int numeroEjes) {
        VehiculoCarga vehiculo = obtenerVehiculoCarga(placa);
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


    // CRUD VEHICULO TRANSPORTE


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
