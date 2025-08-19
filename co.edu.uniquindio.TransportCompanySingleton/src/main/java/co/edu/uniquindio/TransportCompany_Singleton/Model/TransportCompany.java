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


}
