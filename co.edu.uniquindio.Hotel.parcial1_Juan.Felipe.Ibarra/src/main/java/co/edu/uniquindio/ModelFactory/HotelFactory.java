package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.*;
import co.edu.uniquindio.Services.ServicioManager;
import co.edu.uniquindio.Services.ServicioFactoryManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelFactory {
    private static HotelFactory instance;
    private Hotel hotel;
    private ServicioFactoryManager servicioFactoryManager;


    private HotelFactory() {
        hotel = new Hotel("Hotel Uniquindio", "900654732");
        servicioFactoryManager = new ServicioFactoryManager();
    }

    public static HotelFactory getInstance() {
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    // Funcionalidades del Hotel

    // ============= DATOS DE PRUEBA ===============

    public void inicializarDatosPrueba(){
        System.out.println("== Inicializando hotel con datos de prueba ==");

        Habitacion habitacion101 = new Habitacion(101, TipoHabitacion.SIMPLE,80.0);
        Habitacion habitacion201 = new Habitacion(201,TipoHabitacion.DOBLE,120.0);
        Habitacion habitacion301 = new Habitacion(301,TipoHabitacion.SUITE,250.0);
        Habitacion habitacion102 = new Habitacion(102, TipoHabitacion.SIMPLE,80.0);
        Habitacion habitacion202 = new Habitacion(202,TipoHabitacion.DOBLE,120.0);
        Habitacion habitacion302 = new Habitacion(302,TipoHabitacion.SUITE,250.0);
        Habitacion habitacion103 = new Habitacion(103, TipoHabitacion.SIMPLE,85.0);
        Habitacion habitacion203 = new Habitacion(203,TipoHabitacion.DOBLE,130.0);

        hotel.agregarHabitacion(habitacion101);
        hotel.agregarHabitacion(habitacion201);
        hotel.agregarHabitacion(habitacion301);
        hotel.agregarHabitacion(habitacion102);
        hotel.agregarHabitacion(habitacion202);
        hotel.agregarHabitacion(habitacion302);
        hotel.agregarHabitacion(habitacion103);
        hotel.agregarHabitacion(habitacion203);

        Cliente cliente1 = new Cliente("Juan Perez", "12345678");
        Cliente cliente2 = new Cliente("Maria Garcia", "87654321");
        Cliente cliente3 = new Cliente("Carlos Lopez", "11223344");
        Cliente cliente4 = new Cliente("Tatiana Cardenas", "99887766");
        Cliente cliente5 = new Cliente("Ana Rodriguez", "55667788");
        Cliente cliente6 = new Cliente("Pedro Gonzalez", "44556677");

        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);
        hotel.agregarCliente(cliente3);
        hotel.agregarCliente(cliente4);
        hotel.agregarCliente(cliente5);
        hotel.agregarCliente(cliente6);

        Reserva reserva1 = Reserva.builder()
                .Cliente(cliente1)
                .Habitacion(habitacion101)
                .FechaEntrada(LocalDate.now())
                .FechaSalida(LocalDate.now().plusDays(2))
                .MetodoPago("Efectivo")
                .build();

        List<Servicio> serviciosLujo = Arrays.asList(
                new ServicioSpa("Masaje de relajacion"),
                new ServicioRestaurante("Desayuno Continental",true)
        );

        Reserva reserva2 = Reserva.builder()
                .Cliente(cliente2)
                .Habitacion(habitacion301)
                .FechaEntrada(LocalDate.now().plusDays(1))
                .FechaSalida(LocalDate.now().plusDays(4))
                .serviciosContratados(serviciosLujo)
                .MetodoPago("Tarjeta de credito")
                .Descuento(0.15)
                .build();

        Reserva reserva3 = Reserva.builder()
                .Cliente(cliente3)
                .Habitacion(habitacion201)
                .FechaEntrada(LocalDate.now().minusDays(1))
                .FechaSalida(LocalDate.now().plusDays(3))
                .MetodoPago("Transferencia")
                .build();

        SalonEvento salon1 = SalonEvento.builder()
                        .idSalon("123456")
                                .capacidad("28")
                                        .estado(false)
                                                .descripcion("Fiesta de Cumpleaños")
                                                        .build();

        SalonEvento salon2 = SalonEvento.builder()
                        .idSalon("987654")
                                .capacidad("40")
                                        .estado(true)
                                                .descripcion("Fiesta de Graduados")
                                                        .build();


        hotel.agregarReserva(reserva1);
        hotel.agregarReserva(reserva2);
        hotel.agregarReserva(reserva3);
        hotel.agregarSalonEvento(salon1);
        hotel.agregarSalonEvento(salon2);

        System.out.println("Hotel inicializado con:");
        System.out.println("   - " + hotel.getHabitaciones().size() + " habitaciones");
        System.out.println("   - " + hotel.getClientes().size() + " clientes");
        System.out.println("   - " + hotel.getReservas().size() + " reservas iniciales");
        System.out.println("   - " + hotel.getSalonEventos().size() + " salones");
        hotel.mostrarEstadoGeneral();


    }


    // ======= METODOS CRUD CLIENTE =========

    public String crearCliente() {
        System.out.println("\n== CREAR CLIENTE");
        String dni = "33445566";
        String nombre = "Roberto Martinez";

        Cliente nuevoCliente = new Cliente(nombre, dni);
        boolean resultado = hotel.agregarCliente(nuevoCliente);

        String mensaje = resultado ?
                "Cliente creado exitosamente:\nNombre: " + nombre + "\nDNI: " + dni :
                "Error: Cliente ya existe con DNI: " + dni;

        System.out.println(mensaje);
        return mensaje;
    }

    public String buscarCliente(){
        System.out.println("\n== BUSCAR CLIENTE");
        String dniPrueba = "12345678";

        Cliente cliente = hotel.buscarClientePorDni(dniPrueba);
        String mensaje = cliente != null ?
                "Cliente encontrado:\n" + cliente.toString() +
                        "\nReservas activas: " + cliente.getReservasActivas().size() :
                "Cliente no encontrado con DNI: " + dniPrueba;

        System.out.println(mensaje);
        return mensaje;
    }

    public String listarTodosLosClientes(){
        System.out.println("\n== LISTAR TODOS LOS CLIENTES ==");
        List<Cliente> clientes = hotel.obtenerTodosLosClientes();

        StringBuilder mensaje = new StringBuilder("Lista de todos los clientes:\n");
        mensaje.append("═══════════════════════════════\n");

        for(Cliente cliente : clientes){
            mensaje.append("• ").append(cliente.toString()).append("\n");
        }
        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String actualizarCliente(){
        System.out.println("\n== ACTUALIZAR CLIENTE ==");
        String dniPrueba = "87654321"; // DNI de Maria Garcia
        String nuevoNombre = "Maria Garcia Hernandez";

        boolean resultado = hotel.actualizarCliente(dniPrueba, nuevoNombre);
        String mensaje = resultado ?
                "Cliente actualizado exitosamente con DNI: " + dniPrueba :
                "Error: Cliente no encontrado con DNI: " + dniPrueba;

        System.out.println(mensaje);
        return mensaje;
    }

    public String eliminarCliente(){
        System.out.println("\n== ELIMINAR CLIENTE ==");
        String dniPrueba = "55667788"; // DNI de Ana Rodriguez

        boolean resultado = hotel.eliminarCliente(dniPrueba);
        String mensaje = resultado ?
                "Cliente eliminado exitosamente con DNI: " + dniPrueba :
                "Error: No se pudo eliminar cliente (puede tener reservas activas)";

        System.out.println(mensaje);
        return mensaje;
    }


    // ======= METODOS CRUD HABITACION =======

    public String crearHabitacion(){
        System.out.println("\n== CREAR HABITACION ==");
        int id = 401;
        TipoHabitacion tipo = TipoHabitacion.SUITE;
        double precio = 300.0;

        Habitacion nuevaHabitacion = new Habitacion(id, tipo, precio);
        boolean resultado = hotel.agregarHabitacion(nuevaHabitacion);

        String mensaje = resultado ?
                "Habitación creada exitosamente:\nID: " + id + "\nTipo: " + tipo + "\nPrecio: $" + precio :
                "Error: Habitación ya existe con ID: " + id;

        System.out.println(mensaje);
        return mensaje;
    }

    public String buscarHabitacion(){
        System.out.println("\n== BUSCAR HABITACION ==");
        int idPrueba = 201;

        Habitacion habitacion = hotel.buscarHabitacionPorId(idPrueba);
        String mensaje = habitacion != null ?
                "Habitación encontrada:\n" + habitacion.toString() :
                "Habitación no encontrada con ID: " + idPrueba;

        System.out.println(mensaje);
        return mensaje;
    }

    public String listarTodasLasHabitaciones() {
        System.out.println("\n== LISTAR TODAS LAS HABITACIONES ==");
        List<Habitacion> habitaciones = hotel.obtenerTodasLasHabitaciones();

        StringBuilder mensaje = new StringBuilder("Lista de todas las habitaciones:\n");
        mensaje.append("════════════════════════════════════\n");

        for (Habitacion habitacion : habitaciones) {
            String estado = habitacion.isDisponible() ? "DISPONIBLE" : "OCUPADA";
            mensaje.append("• ").append(habitacion.toString())
                    .append(" - ").append(estado).append("\n");
        }

        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String listarHabitacionesDisponibles() {
        System.out.println("\n== LISTAR HABITACIONES DISPONIBLES ==");
        List<Habitacion> disponibles = hotel.obtenerHabitacionesDisponibles();

        StringBuilder mensaje = new StringBuilder("Habitaciones disponibles:\n");
        mensaje.append("═══════════════════════════════\n");

        for (Habitacion habitacion : disponibles) {
            mensaje.append("• ").append(habitacion.toString()).append("\n");
        }

        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String actualizarPrecioHabitacion(){
        System.out.println("\n== ACTUALIZAR PRECIO HABITACION ==");
        int idPrueba = 102;
        double nuevoPrecio = 90.0;

        boolean resultado = hotel.actualizarPrecioHabitacion(idPrueba, nuevoPrecio);
        String mensaje = resultado ?
                "Precio actualizado exitosamente para habitación ID: " + idPrueba :
                "Error: Habitación no encontrada con ID: " + idPrueba;

        System.out.println(mensaje);
        return mensaje;
    }

    public String eliminarHabitacion(){
        System.out.println("\n== ELIMINAR HABITACION ==");
        int idPrueba = 203;

        boolean resultado = hotel.eliminarHabitacion(idPrueba);
        String mensaje = resultado ?
                "Habitación eliminada exitosamente con ID: " + idPrueba :
                "Error: No se pudo eliminar habitación (puede estar ocupada)";

        System.out.println(mensaje);
        return mensaje;
    }


    // ======= METODOS CRUD RESERVA =======

    public String crearReserva(){
        System.out.println("\n== CREAR RESERVA ==");
        String dniCliente = "44556677"; // Pedro Gonzalez
        int idHabitacion = 103;

        Cliente cliente = hotel.buscarClientePorDni(dniCliente);
        Habitacion habitacion = hotel.buscarHabitacionPorId(idHabitacion);

        if(cliente == null || habitacion == null){
            return "Error: Cliente o habitacion no encontrada";
        }

        Reserva nuevaReserva = Reserva.builder()
                .Cliente(cliente)
                .Habitacion(habitacion)
                .FechaEntrada(LocalDate.now().plusDays(2))
                .FechaSalida(LocalDate.now().plusDays(5))
                .MetodoPago("Tarjeta debito")
                .build();

        boolean resultado = hotel.agregarReserva(nuevaReserva);
        String mensaje = resultado ?
                "Reserva creada exitosamente:\nCliente: " + cliente.getNombre() +
                        "\nHabitación: " + idHabitacion + "\nCosto total: $" +
                        String.format("%.2f", nuevaReserva.calcularCostoTotal()) :
                "Error: No se pudo crear la reserva";

        System.out.println(mensaje);
        return mensaje;
    }

    public String buscarReservaPorCliente(){
        System.out.println("\n== BUSCAR RESERVA POR CLIENTE ==");
        String dniPrueba = "12345678"; // Juan Perez

        List<Reserva> reservas = hotel.buscarReservasPorCliente(dniPrueba);

        StringBuilder mensaje = new StringBuilder("Reservas del cliente con DNI " + dniPrueba + ":\n");
        mensaje.append("═══════════════════════════════════════════\n");

        if (reservas.isEmpty()){
            mensaje.append("No se encontraron reservas para este cliente");
        } else {
            for (Reserva reserva : reservas) {
                mensaje.append("• ").append(reserva.toString()).append("\n");
                mensaje.append("  Costo: $").append(String.format("%.2f", reserva.calcularCostoTotal())).append("\n");
            }
        }
        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String listarTodasLasReservas(){
        System.out.println("\n== LISTAR TODAS LAS RESERVAS ==");
        List<Reserva> reservas = hotel.obtenerTodasLasReservas();

        StringBuilder mensaje = new StringBuilder("Reservas del cliente:\n");
        mensaje.append("═══════════════════════════════════\n");

        for (Reserva reserva : reservas) {
            mensaje.append("• ").append(reserva.toString()).append("\n");
            mensaje.append("  Costo: $").append(String.format("%.2f", reserva.calcularCostoTotal())).append("\n");
        }

        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String listarReservasActivas() {
        System.out.println("\n=== LISTAR RESERVAS ACTIVAS ===");
        List<Reserva> activas = hotel.obtenerReservasActivas();

        StringBuilder mensaje = new StringBuilder("Reservas activas (en curso):\n");
        mensaje.append("══════════════════════════════════\n");

        if (activas.isEmpty()) {
            mensaje.append("No hay reservas activas en este momento");
        } else {
            for (Reserva reserva : activas) {
                mensaje.append("• ").append(reserva.toString()).append("\n");
                mensaje.append("  Estado: EN CURSO\n");
                mensaje.append("  Costo: $").append(String.format("%.2f", reserva.calcularCostoTotal())).append("\n");
            }
        }

        System.out.println(mensaje.toString());
        return mensaje.toString();
    }

    public String actualizarFechasReserva(){
        System.out.println("\n== ACTUALIZAR FECHAS DE RESERVA ==");
        String dniCliente = "11223344"; // Carlos Lopez
        int idHbaitacion = 201;

        Cliente cliente = hotel.buscarClientePorDni(dniCliente);
        Habitacion habitacion = hotel.buscarHabitacionPorId(idHbaitacion);

        if(cliente == null || habitacion == null){
            return "Error: Cliente o habitacion no encontrado";
        }

        LocalDate nuevaEntrada = LocalDate.now().plusDays(1);
        LocalDate nuevaSalida = LocalDate.now().plusDays(4);
        boolean resultado = hotel.actualizarFechasReserva(cliente, habitacion, nuevaEntrada, nuevaSalida);
        String mensaje = resultado ?
                "Fechas actualizadas exitosamente:\nNueva entrada: " + nuevaEntrada +
                        "\nNueva salida: " + nuevaSalida :
                "Error: No se encontró la reserva para actualizar";

        System.out.println(mensaje);
        return mensaje;
    }

    public String cancelarReserva(){
        System.out.println("\n== CANCELAR RESERVA ==");
        String dniCliente = "99887766"; // Tatiana Cardenas

        Cliente cliente = hotel.buscarClientePorDni(dniCliente);
        Habitacion habitacion = hotel.buscarHabitacionPorId(302);

        if(cliente == null || habitacion == null){
            return "Error: Cliente o habitacion no encontrado";
        }

        Reserva reservaTemp = Reserva.builder()
                .Cliente(cliente)
                .Habitacion(habitacion)
                .FechaEntrada(LocalDate.now().plusDays(5))
                .FechaSalida(LocalDate.now().plusDays(8))
                .MetodoPago("Efectivo")
                .build();

        hotel.agregarReserva(reservaTemp);
        System.out.println("Reserva creada temporalmente para demostrar la cancelacion...");

        boolean resultado = hotel.cancelarReserva(cliente, habitacion);
        String mensaje = resultado ?
                "Reserva cancelada exitosamente:\nCliente: " + cliente.getNombre() +
                        "\nHabitación liberada: " + habitacion.getIdHabitacion() +
                        "\nEstado habitación: " + (habitacion.isDisponible() ? "DISPONIBLE" : "OCUPADA") :
                "Error: No se pudo cancelar la reserva";

        System.out.println(mensaje);
        return mensaje;
    }



    // ============ FUNCIONALIDADES ==============



    // "Generador de reporte de ocupacion" - Hotel, Habitacion, Reserva

    public String generarRporteOcupacion(){
        System.out.println("\n=== REPORTE DE OCUPACION ===");

        int totalHabitaciones = hotel.getHabitaciones().size();

        int habitacionesOcupadas = 0;
        for(Habitacion habitacion : hotel.getHabitaciones()){
            if(!habitacion.isDisponible()){
                habitacionesOcupadas++;
            }
        }

        int reservasActivas = hotel.obtenerReservasActivas().size();

        double porcentajeOcupacion = (habitacionesOcupadas * 100.0) / totalHabitaciones;

        double ingresosEstimados = 0;
        for(Reserva reserva : hotel.getReservas()){
            ingresosEstimados += reserva.calcularCostoTotal();
        }

        String reporte = "REPORTE DE OCUPACIÓN\n" +
                "════════════════════════\n" +
                "Total habitaciones: " + totalHabitaciones + "\n" +
                "Habitaciones ocupadas: " + habitacionesOcupadas + "\n" +
                "Habitaciones disponibles: " + (totalHabitaciones - habitacionesOcupadas) + "\n" +
                "Porcentaje ocupación: " + String.format("%.1f", porcentajeOcupacion) + "%\n" +
                "Reservas activas: " + reservasActivas + "\n" +
                "Ingresos estimados: $" + String.format("%.2f", ingresosEstimados) + "\n" +
                "Promedio por reserva: $" + String.format("%.2f", ingresosEstimados / Math.max(1, hotel.getReservas().size()));

        System.out.println(reporte);
        return reporte;
    }



    // PARCIAL

    // Crear salon eventos

    public String crearSalon(){
        System.out.println("\n== CREAR SALON ==");
        String idSalon = "123456";
        String capacidad = "28";
        boolean estado = true;
        String descripcion = "Fiesta de cumpleaños";

        SalonEvento nuevoSalon = new SalonEvento(idSalon,capacidad,estado,descripcion);
        boolean resultado = hotel.agregarSalonEvento(nuevoSalon);

        String mensaje = resultado ?
                "Salon creado exitosamente.": "Error!";

        System.out.println(mensaje);
        return mensaje;

    }


    public String eliminarSalon(){
        System.out.println("\n== ELIMINAR SALON");
        String dniSalon = "987654";

        boolean resultado = hotel.eliminarSalonEvento(dniSalon);
        String mensaje = resultado ?
                "Salon de eventos eliminado exitosamente: " + dniSalon :
                "Error!";
        System.out.println(mensaje);
        return mensaje;
    }



}


