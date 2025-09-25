package co.edu.uniquindio.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaBuilder {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private List<Servicio> serviciosContratados;
    private double descuento;
    private String metodoPago;

    ReservaBuilder(){
        this.serviciosContratados = new ArrayList<>();
        this.descuento = 0.0;
    }


    public ReservaBuilder Cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ReservaBuilder Habitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        return this;
    }

    public ReservaBuilder FechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public ReservaBuilder FechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public ReservaBuilder serviciosContratados(List<Servicio> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
        return this;
    }

    public ReservaBuilder Descuento(Double descuento) {
        this.descuento = descuento;
        return this;
    }

    public ReservaBuilder MetodoPago(String metodoPago){
        this.metodoPago = metodoPago;
        return this;
    }

    public ReservaBuilder agregarServicio(Servicio servicio) {
        this.serviciosContratados.add(servicio);
        return this;
    }


    public Reserva build() {
        return new Reserva(cliente,habitacion,fechaEntrada,fechaSalida,
                serviciosContratados,descuento,metodoPago);
    }

}
