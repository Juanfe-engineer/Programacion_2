package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.*;
import co.edu.uniquindio.Services.ServicioManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelFactory {
    private static HotelFactory instance;
    private Hotel hotel;
    private HotelFactory() {
        hotel = new Hotel("Hotel Uniquindio", "900654732");
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

        hotel.agregarHabitacion(habitacion101);
        hotel.agregarHabitacion(habitacion201);
        hotel.agregarHabitacion(habitacion301);
        hotel.agregarHabitacion(habitacion102);
        hotel.agregarHabitacion(habitacion202);
        hotel.agregarHabitacion(habitacion302);

        Cliente cliente1 = new Cliente("Juan Perez", "12345678");
        Cliente cliente2 = new Cliente("Maria Garcia", "87654321");
        Cliente cliente3 = new Cliente("Carlos Lopez", "11223344");
        Cliente cliente4 = new Cliente("Tatiana Cardenas", "99887766");

        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);
        hotel.agregarCliente(cliente3);
        hotel.agregarCliente(cliente4);

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

        hotel.agregarReserva(reserva1);
        hotel.agregarReserva(reserva2);

        System.out.println("Hotel inicializado con:");
        System.out.println("   - " + hotel.getHabitaciones().size() + " habitaciones");
        System.out.println("   - " + hotel.getClientes().size() + " clientes");
        System.out.println("   - " + hotel.getReservas().size() + " reservas iniciales");


    }

    // ============ FUNCIONALIDAD UNO ===============

    // "Check-in Express" - Cliente, Habitacion, Hotel

    public String procesarCheckInExpress(String dniCliente){
       System.out.println("\n=== CHECK-IN EXPRESS ===");

       Cliente cliente = hotel.buscarClientePorDni(dniCliente);
       if(cliente == null){
           return "Cliente no encontrado con DNI: " + dniCliente;
       }

       if(cliente.getReservasActivas().isEmpty()){
           return "El cliente " + cliente.getNombre() + " no tiene reservas de activas";
       }

       Reserva reservaActiva = cliente.getReservasActivas().get(0);
       Habitacion habitacion = reservaActiva.getHabitacion();

       habitacion.setDisponible(false);
       String mensaje = "CHECK-IN COMPLETADO\n" +
               "Bienvenido " + cliente.getNombre() + "\n" +
               "Habitación asignada: " + habitacion.getIdHabitacion() + " (" + habitacion.getTipoHabitacion() + ")\n" +
               "Servicios incluidos: " + reservaActiva.getServiciosContratados().size();

       System.out.println(mensaje);
       return mensaje;

    }



    // ============ FUNCIONALIDAD DOS ===============

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
            ingresosEstimados = ingresosEstimados + reserva.calcularCostoTotal();
        }

        String reporte = "REPORTE DE OCUPACIÓN\n" +
                "════════════════════════\n" +
                "Total habitaciones: " + totalHabitaciones + "\n" +
                "Habitaciones ocupadas: " + habitacionesOcupadas + "\n" +
                "Porcentaje ocupación: " + (int)porcentajeOcupacion + "%\n" +
                "Reservas activas: " + reservasActivas + "\n" +
                "Ingresos estimados: $" + (int)ingresosEstimados;

        System.out.println(reporte);
        return reporte;
    }



    // ============ FUNCIONALIDAD TRES ===============

    // "Optimizador Automatico de servicios VIP" - Cliente , Reserva, ServicioManager, multiples servicios

    public String optimizarServiciosVIP(String dniCliente){
        ServicioManager manager = new ServicioManager();
        System.out.println("\n=== OPTIMIZADOR VIP AUTOMATICO ===");

        Cliente cliente = hotel.buscarClientePorDni(dniCliente);
        if(cliente == null){
            return "Cliente no encontrado";
        }

        boolean esVIP = cliente.getReservasActivas().size() >= 2;
        if(!esVIP){
            return "Cliente " + cliente.getNombre() + " no califica como VIP";
        }

        System.out.println("Cliente VIP detectado: " + cliente.getNombre());

        List<Servicio> paqueteVIP = new ArrayList<>();

        for (Reserva reserva : cliente.getReservasActivas()){
            String tipoHabitacion = String.valueOf(reserva.getHabitacion().getTipoHabitacion());

            switch (tipoHabitacion){
                case "suite":
                    paqueteVIP.add(new ServicioSpa("Masaje VIP Executive",true));
                    paqueteVIP.add(new ServicioRestaurante("Cena Gourmet privada",true));
                    paqueteVIP.add(new ServicioLavanderia(true,true));
                    break;
                case "doble":
                    paqueteVIP.add(new ServicioSpa("Terapia de pareja",false));
                    paqueteVIP.add(new ServicioRestaurante("Cena romantica",false));
                    break;
                case "simple":
                    paqueteVIP.add(new ServicioRestaurante("Desayuno continental", true));
                    paqueteVIP.add(new ServicioHabitacion("Servicio premium", 40.0,TipoServicioHabitacion.LIMPIEZA));
                    break;
            }

        }

        double descuentoVIP = Math.min(0.3, cliente.getReservasActivas().size() * 0.08);

        Reserva reservaPrincipal = cliente.getReservasActivas().get(0);
        double costoOriginal = reservaPrincipal.calcularCostoTotal();

        for (Servicio servicio : paqueteVIP){
            reservaPrincipal.agregarServicio(servicio);
        }

        reservaPrincipal.setDescuento(descuentoVIP);
        double costoFinal = reservaPrincipal.calcularCostoTotal();

        String resultado = "OPTIMIZACIÓN VIP COMPLETADA\n" +
                "══════════════════════════════\n" +
                "Cliente: " + cliente.getNombre() + "\n" +
                "Servicios agregados: " + paqueteVIP.size() + "\n" +
                "Descuento VIP aplicado: " + String.format("%.0f", descuentoVIP * 100) + "%\n" +
                "Costo original: $" + String.format("%.2f", costoOriginal) + "\n" +
                "Costo final: $" + String.format("%.2f", costoFinal) + "\n" +
                "Ahorro total: $" + String.format("%.2f", costoOriginal - costoFinal) + "\n" +
                "Servicios personalizados creados automáticamente";

        System.out.println(resultado);
        return resultado;
    }

}
