package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String DNI;
    private List<Reserva> reservasActivas;

    public Cliente(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.reservasActivas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservasActivas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservasActivas.remove(reserva);
    }

    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }

    public void setReservasActivas(List<Reserva> reservasActivas) {
        this.reservasActivas = reservasActivas;
    }

    @Override
    public String toString() {
        return "Cliente " +
                "nombre = '" + nombre + '\'' +
                ", DNI = '" + DNI + '\'' +
                ", reservas = " + reservasActivas.size();
    }
}
