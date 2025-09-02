package co.edu.uniquindio.Model;

import co.edu.uniquindio.Services.ServicioManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private List<Servicio> serviciosContratados;
    private double descuento;
    private String metodoPago;
    private ServicioManager servicioManager;


    public Reserva(Cliente cliente,Habitacion habitacion, LocalDate fechaEntrada,
                   LocalDate fechaSalida, List<Servicio> serviciosContratados,
                   double descuento,String metodoPago) {

        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.serviciosContratados = serviciosContratados;
        this.descuento = descuento;
        this.metodoPago = metodoPago;
        this.servicioManager = new ServicioManager();
    }

    public static ReservaBuilder builder(){
        return new ReservaBuilder();
    }

    public void agregarServicio(Servicio servicio) {
        serviciosContratados.add(servicio);
    }

    public double calcularCostoTotal() {
        double costoHabitacion = habitacion.getPrecioHabitacion();
        double costoServicios = servicioManager.calcularCostoTotal(serviciosContratados);
        return(costoHabitacion + costoServicios) * (1 - descuento);
    }

    //Getters and Setters


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<Servicio> getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(List<Servicio> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Reserva{cliente=" + cliente.getNombre() +
                ", habitacion=" + habitacion.getIdHabitacion() +
                ", fechas=" + fechaEntrada + " a " + fechaSalida + "}";
    }

}
