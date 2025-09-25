package co.edu.uniquindio.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String nit;
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<SalonEvento> salonEventos;

    public Hotel(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.salonEventos = new ArrayList<>();
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

    public List<SalonEvento> getSalonEventos() {
        return salonEventos;
    }

    // =========== CRUD CLIENTE =============

    // CREATE

    public boolean agregarCliente(Cliente cliente) {
        if(buscarClientePorDni(cliente.getDNI()) == null){
            clientes.add(cliente);
            System.out.println("Cliente agregado: " + cliente.getNombre());
            return true;
        }
        System.out.println("Cliente ya existe con DNI: " + cliente.getDNI());
        return false;
    }

    // READ - Buscar por DNI

    public Cliente buscarClientePorDni(String dni) {
        for(Cliente cliente : clientes){
            if(cliente.getDNI().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    // READ - Obtener todos los Clientes

    public List<Cliente> obtenerTodosLosClientes(){
        return new ArrayList<>(clientes);
    }

    // UPDATE

    public boolean actualizarCliente(String dni, String nuevoNombre) {
        Cliente cliente = buscarClientePorDni(dni);
        if(cliente != null){
            String nombreAnterior = cliente.getNombre();
            cliente.setNombre(nuevoNombre);
            System.out.println("Cliente actualizado: " + nombreAnterior + " -> " + nuevoNombre);
            return true;
        }
        System.out.println("Cliente no encontrado con DNI: " + dni);
        return false;
    }

    // DELETE

    public boolean eliminarCliente(String dni) {
        Cliente cliente = buscarClientePorDni(dni);
        if(cliente != null){
            if(!cliente.getReservasActivas().isEmpty()){
                System.out.println("No se pueden eliminar Clientes con reservas activas");
                return false;
            }
            clientes.remove(cliente);
            System.out.println("Cliente eliminado: " + cliente.getNombre());
            return true;
        }
        System.out.println("Cliente no encontrado con DNI: " + dni);
        return false;
    }


    // ======== CRUD HABITACION ==========

    // CREATE

    public boolean agregarHabitacion(Habitacion habitacion) {
        if(buscarHabitacionPorId(habitacion.getIdHabitacion()) == null){
            habitaciones.add(habitacion);
            System.out.println("✓ Habitación agregada: " + habitacion.getIdHabitacion() +
                    " - " + habitacion.getTipoHabitacion());
            return true;
        }
        System.out.println("Habitacion ya existe con ID: " + habitacion.getIdHabitacion());
        return false;
    }

    // READ - Buscar por ID

    public Habitacion buscarHabitacionPorId(int id) {
        for(Habitacion habitacion : habitaciones){
            if(habitacion.getIdHabitacion() == id){
                return habitacion;
            }
        }
        return null;
    }

    // READ - Obtener todas las habitaciones

    public List<Habitacion> obtenerTodasLasHabitaciones(){
        return new ArrayList<>(habitaciones);
    }

    // READ - Obtener habitaciones disponibles

    public List<Habitacion> obtenerHabitacionesDisponibles(){
        List<Habitacion> disponibles = new ArrayList<>();
        for(Habitacion habitacion : habitaciones){
            if(habitacion.isDisponible()){
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    // UPDATE

    public boolean actualizarPrecioHabitacion(int id, double nuevoPrecio) {
        Habitacion habitacion = buscarHabitacionPorId(id);
        if(habitacion != null){
            double precioAnterior = habitacion.getPrecioHabitacion();
            habitacion.setPrecioHabitacion(nuevoPrecio);
            System.out.println("✓ Precio actualizado habitación " + id +
                    ": $" + precioAnterior + " → $" + nuevoPrecio);
            return true;
        }
        System.out.println("Habitacion no encontrado con ID: " + id);
        return false;
    }

    // DELETE

    public boolean eliminarHabitacion(int id) {
        Habitacion habitacion = buscarHabitacionPorId(id);
        if(habitacion != null){
            if(!habitacion.isDisponible()){
                System.out.println("No se puede eliminar una habitacion ocupada");
                return false;
            }
            habitaciones.remove(habitacion);
            System.out.println("Habitacion eliminada: " + id);
            return true;
        }
        System.out.println("Habitacion no encontrado con ID: " + id);
        return false;
    }


    // ========= CRUD RESERVA =========

    // CREATE

    public boolean agregarReserva(Reserva reserva) {
        if(reserva.getHabitacion().isDisponible()){
            reservas.add(reserva);

            reserva.getHabitacion().setDisponible(false);

            reserva.getCliente().agregarReserva(reserva);
            System.out.println("✓ Reserva creada para " + reserva.getCliente().getNombre() +
                    " en habitación " + reserva.getHabitacion().getIdHabitacion());
            return true;
        }
        System.out.println("Habitacion no disponible para reserva");
        return false;
    }

    // READ - Buscar reservas por cliente

    public List<Reserva> buscarReservasPorCliente(String dni){
        List<Reserva> reservasCliente = new ArrayList<>();
        for(Reserva reserva : reservas){
            if(reserva.getCliente().getDNI().equals(dni)){
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }

    // READ - obtener todas las reservas

    public List<Reserva> obtenerTodasLasReservas(){
        return new ArrayList<>(reservas);
    }

    // READ - Obtener reservas activas (fchas validas)

    public List<Reserva> obtenerReservasActivas(){
        List<Reserva> activas = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for(Reserva reserva : reservas){
            if(reserva.getFechaEntrada().isBefore(hoy.plusDays(1)) &&
                    reserva.getFechaSalida().isAfter(hoy.minusDays(1))){
                activas.add(reserva);
            }
        }
        return activas;
    }

    // UPDATE - Actualizar fechas de reserva

    public boolean actualizarFechasReserva(Cliente cliente, Habitacion habitacion,
                                           LocalDate nuevaEntrada, LocalDate nuevaSalida) {
        for(Reserva reserva : reservas){
            if(reserva.getCliente().equals(cliente) && reserva.getHabitacion().equals(habitacion)){
                reserva.setFechaEntrada(nuevaEntrada);
                reserva.setFechaSalida(nuevaSalida);
                System.out.println("✓ Fechas actualizadas para reserva de " + cliente.getNombre());
                return true;
            }
        }
        System.out.println("Reserva no encontrada");
        return false;
    }

    // DELETE - Cancelar reserva

    public boolean cancelarReserva(Cliente cliente, Habitacion habitacion) {
        for(int i = 0; i < reservas.size(); i++){
            Reserva reserva = reservas.get(i);
            if(reserva.getCliente().equals(cliente) && reserva.getHabitacion().equals(habitacion)){
                habitacion.setDisponible(true);
                cliente.eliminarReserva(reserva);
                reservas.remove(i);
                System.out.println("✓ Reserva cancelada para " + cliente.getNombre());
                return true;
            }
        }
        System.out.println("Reserva no encontrada para cancelar");
        return false;
    }


    // =============== METODOS AUXILIARES ==============

    public void mostrarEstadoGeneral() {
        System.out.println("\n=== ESTADO GENERAL DEL HOTEL ===");
        System.out.println("Hotel: " + nombre);
        System.out.println("Total Clientes: " + clientes.size());
        System.out.println("Total Habitaciones: " + habitaciones.size());
        System.out.println("Habitaciones Disponibles: " + obtenerHabitacionesDisponibles().size());
        System.out.println("Total Reservas: " + reservas.size());
        System.out.println("Reservas Activas: " + obtenerReservasActivas().size());
    }





    // ===== CRUD SALON EVENTO ======

    // CREATE

    public boolean agregarSalonEvento (SalonEvento salonEvento){
        if(salonEvento.getEstado(false)){
            salonEventos.add(salonEvento);
            System.out.println("Salon Agregado: " + salonEvento.getIdSalon());
            return true;
        }
        return false;
    }


    // READ - Buscar por DNI

    public SalonEvento buscarSalonDNI(String dni) {
        for(SalonEvento salonEvento : salonEventos){
            if(salonEvento.getIdSalon().equals(dni)){
                return salonEvento;
            }
        }
        return null;
    }


    // DELETE

    public boolean eliminarSalonEvento(String dni) {
        SalonEvento salonEvento = buscarSalonDNI(dni);
        if(salonEvento != null){
            if(!salonEvento.getEstado(false)){
                System.out.println("No se puede eliminar un salon Ocupado");
                return false;
            }

           salonEventos.remove(salonEvento);
           System.out.println("Salon eliminado: " + salonEvento.getIdSalon());
           return true;
        }
        System.out.println("Salon no encontrado");
        return false;
    }

}















































