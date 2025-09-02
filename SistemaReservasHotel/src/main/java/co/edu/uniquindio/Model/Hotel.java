package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String nit;
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public Hotel(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters and Setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    // ========== Gestion de habitaciones ============

    public boolean agregarHabitacion(Habitacion habitacion) {
        if (habitacion == null)
            return false;
        for(Habitacion h : habitaciones){
            if(h.getIdHabitacion() == habitacion.getIdHabitacion()){
                return false;
            }
        }
        habitaciones.add(habitacion);
        return true;
    }

    public Habitacion buscarHabitacion(int id) {
        for(Habitacion h : habitaciones){
            if(h.getIdHabitacion() == id){
                return h;
            }
        }
        return null;
    }

    public List<Habitacion> buscarHabitacionePorTipo(TipoHabitacion tipo){
        List<Habitacion> resultado = new ArrayList<>();
        for(Habitacion h : habitaciones){
            if(h.getTipoHabitacion() == tipo){
                resultado.add(h);
            }
        }
        return resultado;
    }

    public List<Habitacion> obtenerHabitacionesDisponibles(){
        List<Habitacion> disponibles = new ArrayList<>();
        for(Habitacion h : habitaciones){
            if(h.isDisponible()){
                disponibles.add(h);
            }
        }
        return disponibles;
    }


    // ========== Gestion de Clientes =============

    public boolean agregarCliente(Cliente cliente) {
       if(cliente == null){
           return false;
       }
       for(Cliente c : clientes){
           if(c.getDNI().equals(cliente.getDNI())){
               return false;
           }
       }
       clientes.add(cliente);
       return true;
    }

    public Cliente buscarClientePorDni(String dni) {
        for(Cliente c : clientes){
            if(c.getDNI().equals(dni)){
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCliente(String dni) {
        Cliente cliente = buscarClientePorDni(dni);
        if(cliente != null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public List<Cliente> obtenerClientes() {
        return new ArrayList<>(clientes);
    }


    // =========== Gestion de Reservas =============

    public boolean agregarReserva (Reserva reserva) {
        if(reserva == null){
            return false;
        }
        Habitacion habitacion = reserva.getHabitacion();
        Cliente cliente = reserva.getCliente();

        if(!habitacion.isDisponible()){
            return false;
        }
        habitacion.setDisponible(false);
        cliente.agregarReserva(reserva);

        reservas.add(reserva);
        return true;
    }

    public boolean finalizarReserva(Reserva reserva) {
        if(reserva == null){
            return false;
        }
        Habitacion habitacion = reserva.getHabitacion();
        Cliente cliente = reserva.getCliente();

        habitacion.setDisponible(true);
        cliente.eliminarReserva(reserva);

        return reservas.remove(reserva);
    }

    public List<Reserva> obtenerReservasActivas(){
        return new ArrayList<>(reservas);
    }

    // Estadisticas del hotel

    public void mostrarEstadisticas(){
        System.out.println("======== Estadisticas del Hotel =======");

        int totalHabitaciones = habitaciones.size();
        int disponibles = 0;
        int ocupadas = 0;

        int simples = 0;
        int dobles = 0;
        int suites = 0;

        for(Habitacion h : habitaciones){
            if(h.isDisponible()) disponibles++;
            else ocupadas++;

            if(h.getTipoHabitacion() == TipoHabitacion.SIMPLE) simples++;
            if(h.getTipoHabitacion() == TipoHabitacion.DOBLE) dobles++;
            if(h.getTipoHabitacion() == TipoHabitacion.SUITE) suites++;
        }

        System.out.println("Total de habitaciones: " + totalHabitaciones);
        System.out.println("Disponibles: " + disponibles);
        System.out.println("Ocupadas: " + ocupadas);
        System.out.println(" - Simples: " + simples);
        System.out.println(" - Dobles: " + dobles);
        System.out.println(" - Suites: " + suites);

        // Clientes
        System.out.println("Total de clientes registrados: " + clientes.size());

        // Reservas
        System.out.println("Total de reservas: " + reservas.size());

        System.out.println("====================================");
    }


}
