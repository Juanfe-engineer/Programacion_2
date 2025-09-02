package co.edu.uniquindio.Model;

import co.edu.uniquindio.Services.IConsumible;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int idHabitacion;
    private TipoHabitacion tipoHabitacion;
    private double precioHabitacion;
    private boolean disponible;
    private List<Servicio> serviciosAsociados;

    public Habitacion(int idHabitacion, TipoHabitacion tipoHabitacion, double precioHabitacion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.disponible = true;
        this.serviciosAsociados = new ArrayList<>();
    }

    // DIP

    public void agregarServicio(Servicio servicio){
        serviciosAsociados.add(servicio);
    }

    public void eliminarServicio(Servicio servicio){
        serviciosAsociados.remove(servicio);
    }

    public void ejecutarServicios(){
        System.out.println("Ejecutando servicios en habitacion " + idHabitacion);
        for(Servicio servicio : serviciosAsociados){
            if(servicio instanceof IConsumible){
                ((IConsumible) servicio).consumir();
            }
        }
    }

    // Getters and Setters


    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public List<Servicio> getServiciosAsociados(){
        return serviciosAsociados;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + idHabitacion +
                ", tipo=" + tipoHabitacion +
                ", precio=" + precioHabitacion +
                ", disponible=" + disponible +
                '}';
    }
}
