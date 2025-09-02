package co.edu.uniquindio;

import co.edu.uniquindio.ModelFactory.HotelFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelFactory hotelFactory = HotelFactory.getInstance();
        hotelFactory.inicializarDatosPrueba();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ HOTEL =====");
            System.out.println("1. Check-In Express");
            System.out.println("2. Reporte de Ocupación");
            System.out.println("3. Optimizar Servicios VIP");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dniCheckIn = sc.nextLine();
                    hotelFactory.procesarCheckInExpress(dniCheckIn);
                    break;

                case 2:
                    hotelFactory.generarRporteOcupacion();
                    break;

                case 3:
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dniVIP = sc.nextLine();
                    hotelFactory.optimizarServiciosVIP(dniVIP);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

