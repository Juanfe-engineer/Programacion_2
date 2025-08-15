package co.edu.uniquindio.TransportCompany.Model;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String nombre;
    private String nit;
    private Propietario propietario;
    private VehiculoCarga vehiculoCarga;
    private List<VehiculoTransporte> vehiculoTransportes;

    public TransportCompany(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.vehiculoTransportes = new ArrayList<>();
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
    public Propietario getPropietario() {
        return propietario;
    }
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    public VehiculoCarga getVehiculoCarga() {
        return vehiculoCarga;
    }
    public void setVehiculoCarga(VehiculoCarga vehiculoCarga) {
        this.vehiculoCarga = vehiculoCarga;
    }
    public List<VehiculoTransporte> getVehiculoTransportes() {
        return vehiculoTransportes;
    }
    public void setVehiculoTransportes(List<VehiculoTransporte> vehiculoTransportes) {
        this.vehiculoTransportes = vehiculoTransportes;
    }

}
