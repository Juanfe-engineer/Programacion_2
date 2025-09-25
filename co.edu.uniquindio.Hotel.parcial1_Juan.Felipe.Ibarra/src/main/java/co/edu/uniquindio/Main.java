package co.edu.uniquindio;

import co.edu.uniquindio.ModelFactory.HotelFactory;
import java.util.Scanner;

public class Main {
    private static final String SEPARADOR = "═".repeat(60);
    private static final String LINEA = "─".repeat(60);

    public static void main(String[] args) {
        mostrarBienvenida();

        // Inicializar el sistema
        HotelFactory factory = HotelFactory.getInstance();
        factory.inicializarDatosPrueba();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion(scanner);

            limpiarPantalla();
            ejecutarOpcion(factory, opcion);

            if (opcion != 0) {
                pausar(scanner);
            }

        } while (opcion != 0);

        mostrarDespedida();
        scanner.close();
    }

    private static void mostrarBienvenida() {
        limpiarPantalla();
        System.out.println(SEPARADOR);
        System.out.println("           SISTEMA DE GESTIÓN HOTELERA           ");
        System.out.println("           Hotel Uniquindio              ");
        System.out.println(SEPARADOR);
        System.out.println("✓ Datos de prueba precargados");
        System.out.println("✓ Funcionalidades especiales incluidas");
        System.out.println(SEPARADOR);
        System.out.println("Presione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    private static void mostrarMenuPrincipal() {
        limpiarPantalla();
        System.out.println(SEPARADOR);
        System.out.println("                    MENÚ PRINCIPAL                    ");
        System.out.println(SEPARADOR);

        System.out.println(" GESTIÓN DE CLIENTES");
        System.out.println("   1. Crear Cliente Nuevo");
        System.out.println("   2️. Buscar Cliente por DNI");
        System.out.println("   3️. Listar Todos los Clientes");
        System.out.println("   4️. Actualizar Datos de Cliente");
        System.out.println("   5️. Eliminar Cliente");

        System.out.println("\n GESTIÓN DE HABITACIONES");
        System.out.println("   6️. Crear Nueva Habitación");
        System.out.println("   7️. Buscar Habitación por ID");
        System.out.println("   8️. Listar Todas las Habitaciones");
        System.out.println("   9️. Ver Habitaciones Disponibles");
        System.out.println("   10. Actualizar Precio de Habitación");
        System.out.println("   11. Eliminar Habitación");

        System.out.println("\n GESTIÓN DE RESERVAS");
        System.out.println("   12. Crear Nueva Reserva");
        System.out.println("   13. Buscar Reservas por Cliente");
        System.out.println("   14. Listar Todas las Reservas");
        System.out.println("   15. Ver Reservas Activas");
        System.out.println("   16. Actualizar Fechas de Reserva");
        System.out.println("   17. Cancelar Reserva");

        System.out.println("\n FUNCIONALIDADES ESPECIALES");
        System.out.println("   18. Generar Reporte de Ocupación");

        System.out.println("\n Parcial");

        System.out.println("   19. Crear Salon eventos        ");
        System.out.println("   20. Eliminar Salon eventos     ");

        System.out.println("\n SALIR");
        System.out.println("   0. Salir del Sistema");

        System.out.println(SEPARADOR);
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.print(" Seleccione una opción (0-20): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion >= 0 && opcion <= 20) {
                    opcionValida = true;
                } else {
                    System.out.println(" Opción fuera de rango. Ingrese un número entre 0 y 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Por favor ingrese un número válido.");
            }
        }

        return opcion;
    }


    private static void ejecutarOpcion(HotelFactory factory, int opcion) {
        String resultado;

        switch (opcion) {
            case 1:
                mostrarTituloOperacion("CREAR CLIENTE NUEVO");
                mostrarInfoOperacion("Se creará un cliente con datos predefinidos");
                factory.crearCliente();

                break;

            case 2:
                mostrarTituloOperacion("BUSCAR CLIENTE POR DNI");
                mostrarInfoOperacion("Buscando cliente con DNI: 12345678 (Juan Perez)");
                factory.buscarCliente();
                break;

            case 3:
                mostrarTituloOperacion("LISTAR TODOS LOS CLIENTES");
                mostrarInfoOperacion("Mostrando todos los clientes registrados");
                factory.listarTodosLosClientes();
                break;

            case 4:
                mostrarTituloOperacion("ACTUALIZAR DATOS DE CLIENTE");
                mostrarInfoOperacion("Actualizando nombre de Maria Garcia (DNI: 87654321)");
                factory.actualizarCliente();
                break;

            case 5:
                mostrarTituloOperacion("ELIMINAR CLIENTE");
                mostrarInfoOperacion("Eliminando cliente Ana Rodriguez (DNI: 55667788)");
                factory.eliminarCliente();
                break;

            case 6:
                mostrarTituloOperacion("CREAR NUEVA HABITACIÓN");
                mostrarInfoOperacion("Creando habitación 401 tipo Suite");
                factory.crearHabitacion();
                break;

            case 7:
                mostrarTituloOperacion("BUSCAR HABITACIÓN POR ID");
                mostrarInfoOperacion("Buscando habitación con ID: 201");
                factory.buscarHabitacion();
                break;

            case 8:
                mostrarTituloOperacion("LISTAR TODAS LAS HABITACIONES");
                mostrarInfoOperacion("Mostrando todas las habitaciones con su estado");
                factory.listarTodasLasHabitaciones();
                break;

            case 9:
                mostrarTituloOperacion("VER HABITACIONES DISPONIBLES");
                mostrarInfoOperacion("Mostrando solo habitaciones disponibles para reserva");
                factory.listarHabitacionesDisponibles();
                break;

            case 10:
                mostrarTituloOperacion("ACTUALIZAR PRECIO DE HABITACIÓN");
                mostrarInfoOperacion("Actualizando precio de habitación 102 a $90.00");
                factory.actualizarPrecioHabitacion();
                break;

            case 11:
                mostrarTituloOperacion("ELIMINAR HABITACIÓN");
                mostrarInfoOperacion("Eliminando habitación 203 (debe estar disponible)");
                factory.eliminarHabitacion();
                break;

            case 12:
                mostrarTituloOperacion("CREAR NUEVA RESERVA");
                mostrarInfoOperacion("Creando reserva para Pedro Gonzalez en habitación 103");
                factory.crearReserva();
                break;

            case 13:
                mostrarTituloOperacion("BUSCAR RESERVAS POR CLIENTE");
                mostrarInfoOperacion("Buscando reservas de Juan Perez (DNI: 12345678)");
                factory.buscarReservaPorCliente();
                break;

            case 14:
                mostrarTituloOperacion("LISTAR TODAS LAS RESERVAS");
                mostrarInfoOperacion("Mostrando todas las reservas del sistema");
                factory.listarTodasLasReservas();
                break;

            case 15:
                mostrarTituloOperacion("VER RESERVAS ACTIVAS");
                mostrarInfoOperacion("Mostrando reservas que están en curso actualmente");
                factory.listarReservasActivas();

                break;

            case 16:
                mostrarTituloOperacion("ACTUALIZAR FECHAS DE RESERVA");
                mostrarInfoOperacion("Actualizando fechas de reserva de Carlos Lopez");
                factory.actualizarFechasReserva();
                break;

            case 17:
                mostrarTituloOperacion("CANCELAR RESERVA");
                mostrarInfoOperacion("Cancelando reserva de prueba");
                factory.cancelarReserva();
                break;

            case 18:
                mostrarTituloOperacion("REPORTE DE OCUPACIÓN");
                mostrarInfoOperacion("Generando reporte completo del estado del hotel");
                factory.generarRporteOcupacion();
                break;


            case 19:
                mostrarTituloOperacion("CREAR SALON EVENTOS NUEVO");
                mostrarInfoOperacion("Creando salon de eventos....");
                factory.crearSalon();
                break;

            case 20:
                mostrarInfoOperacion("ELIMINAR SALON DE EVENTOS");
                mostrarInfoOperacion("Eliminando salon de eventos...");
                factory.eliminarSalon();


            case 0:
                break;

            default:
                System.out.println("Opción no válida. Por favor intente nuevamente.");
        }
    }

    private static void mostrarTituloOperacion(String titulo) {
        System.out.println(SEPARADOR);
        System.out.println(" " + titulo);
        System.out.println(SEPARADOR);
    }

    private static void mostrarInfoOperacion(String info) {
        System.out.println(" " + info);
        System.out.println(LINEA);
    }

    private static void mostrarResultado(String resultado) {
        System.out.println("\n RESULTADO:");
        System.out.println(LINEA);
        System.out.println(resultado);
        System.out.println(LINEA);
    }

    private static void pausar(Scanner scanner) {
        System.out.println("\n Presione Enter para volver al menú principal...");
        scanner.nextLine();
    }

    private static void mostrarDespedida() {
        limpiarPantalla();
        System.out.println(SEPARADOR);
        System.out.println("           ¡GRACIAS POR USAR EL SISTEMA!           ");
        System.out.println("                Hotel Uniquindio");
        System.out.println(SEPARADOR);
        System.out.println(" Sistema desarrollado exitosamente");
        System.out.println(" Todos los CRUDs funcionando correctamente");
        System.out.println(" Funcionalidades especiales implementadas");
        System.out.println(SEPARADOR);
        System.out.println("              ¡Hasta la próxima! ");
        System.out.println(SEPARADOR);
    }

    private static void limpiarPantalla() {
        // Simular limpiar pantalla
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}



