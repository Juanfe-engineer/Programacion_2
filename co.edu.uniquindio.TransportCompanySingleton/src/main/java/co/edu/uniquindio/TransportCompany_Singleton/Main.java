package co.edu.uniquindio.TransportCompany_Singleton;

import co.edu.uniquindio.TransportCompany_Singleton.Model.Propietario;
import co.edu.uniquindio.TransportCompany_Singleton.Model.VehiculoCarga;
import co.edu.uniquindio.TransportCompany_Singleton.Model.VehiculoTransporte;
import co.edu.uniquindio.TransportCompany_Singleton.ModelFactory.ModelFactory;

import javax.swing.*;

class MenuManager {
    private static MenuManager instance;
    private ModelFactory modelFactory;

    private MenuManager() {
        modelFactory = ModelFactory.getInstance();
    }
    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public void mostrarMenuPrincipal() {
        int opcion = 0;
        do {
            String menu = "═════════════════════════════════════════\n" +
                          "           SISTEMA DE TRANSPORTE\n" +
                          "              'LA CARRETA'\n" +
                          "═════════════════════════════════════════\n\n" +
                          "1. Inicializar Datos de Prueba\n" +
                          "2. Crear Propietario y Vehículo Carga\n" +
                          "3. Calcular Pasajeros por Vehículo\n" +
                          "4. Obtener Propietarios por Peso\n" +
                          "5. Obtener Usuarios por Vehículo\n" +
                          "6. Propietarios Mayores de 40\n" +
                          "7. ➤ CRUD Propietarios\n" +
                          "8. ➤ CRUD Vehículos Carga\n" +
                          "9. ➤ CRUD Vehículos Transporte\n" +
                          "0. Salir\n\n" +
                          "Seleccione una opción:";

            String input = JOptionPane.showInputDialog(null, menu, "Sistema de Gestión", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcion) {
                case 1:
                    modelFactory.inicializarDatosPrueba();
                    break;
                case 2:
                    modelFactory.crearPropietarioVehiculoCarga();
                    break;
                case 3:
                    modelFactory.calcularPasajerosPorVehiculo();
                    break;
                case 4:
                    modelFactory.obtenerPropietariosPorPeso();
                    break;
                case 5:
                    modelFactory.obtenerUsuariosPorVehiculo();
                    break;
                case 6:
                    modelFactory.obtenerPropietariosMayoresDe40();
                    break;
                case 7:
                    mostrarMenuCrudPropietarios();
                    break;
                case 8:
                    mostrarMenuCrudVehiculosCarga();
                    break;
                case 9:
                    mostrarMenuCrudVehiculosTransporte();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar nuestro sistema!\n¡Hasta luego!", "Despedida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);
    }


    public void mostrarMenuCrudPropietarios() {
        int opcion = 0;
        do {
            String menu = "═══════════════════════════════════════\n" +
                          "          CRUD PROPIETARIOS\n" +
                          "═══════════════════════════════════════\n\n" +
                          "1. Buscar Propietario\n" +
                          "2. Agregar Propietarios\n" +
                          "3. Obtener Propietario\n" +
                          "4. Actualizar Propietario\n" +
                          "5. Eliminar Propietario\n" +
                          "0. Volver al Menú Principal\n\n" +
                          "Seleccione una opción:";

            String input = JOptionPane.showInputDialog(null, menu, "CRUD Propietarios", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcion) {
                case 1: {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario a buscar:");
                    if (nombre == null || nombre.trim().equals("")) break;

                    String resultado = modelFactory.buscarPropietarioNombre(nombre);
                    if (resultado == null || resultado.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "No se encontró propietario con ese nombre.");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                    break;
                }

                case 2: {
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String identificacion = JOptionPane.showInputDialog("Identificación:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String telefono = JOptionPane.showInputDialog("Teléfono:");
                    String edadStr = JOptionPane.showInputDialog("Edad:");
                    String pesoStr = JOptionPane.showInputDialog("Peso:");

                    if (nombre == null || identificacion == null || email == null || telefono == null ||
                            edadStr == null || pesoStr == null ||
                            nombre.trim().equals("") || identificacion.trim().equals("") ||
                            email.trim().equals("") || telefono.trim().equals("") ||
                            edadStr.trim().equals("") || pesoStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        int edad = Integer.parseInt(edadStr);
                        double peso = Double.parseDouble(pesoStr);
                        boolean ok = modelFactory.agregarPropietario(nombre, identificacion, email, telefono, edad, peso);
                        JOptionPane.showMessageDialog(null, ok ? "Propietario agregado correctamente." :
                                "Ya existe un propietario con esa identificación.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Edad o peso inválidos.");
                    }
                    break;
                }
                case 3: {
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");
                    if (identificacion == null || identificacion.trim().equals("")) break;

                    Propietario p = modelFactory.obtenerPropietario(identificacion);
                    if (p == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró propietario con esa identificación.");
                    } else {
                        JOptionPane.showMessageDialog(null, p.toString());
                    }
                    break;
                }
                case 4: {
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String identificacion = JOptionPane.showInputDialog("Identificación (del propietario a actualizar):");
                    String email = JOptionPane.showInputDialog("Email:");
                    String telefono = JOptionPane.showInputDialog("Teléfono:");
                    String edadStr = JOptionPane.showInputDialog("Edad:");
                    String pesoStr = JOptionPane.showInputDialog("Peso:");

                    if (nombre == null || identificacion == null || email == null || telefono == null ||
                            edadStr == null || pesoStr == null ||
                            nombre.trim().equals("") || identificacion.trim().equals("") ||
                            email.trim().equals("") || telefono.trim().equals("") ||
                            edadStr.trim().equals("") || pesoStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        int edad = Integer.parseInt(edadStr);
                        double peso = Double.parseDouble(pesoStr);
                        boolean ok = modelFactory.actualizarPropietario(nombre, identificacion, email, telefono, edad, peso);
                        JOptionPane.showMessageDialog(null, ok ? "Propietario actualizado correctamente." :
                                "No existe un propietario con esa identificación.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Edad o peso inválidos.");
                    }
                    break;
                }
                case 5: {
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario a eliminar:");
                    if (identificacion == null || identificacion.trim().equals("")) break;

                    boolean ok = modelFactory.eliminarPropietario(identificacion);
                    JOptionPane.showMessageDialog(null, ok ? "Propietario eliminado." :
                            "No existe un propietario con esa identificación.");
                    break;
                }
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } while (opcion != 0);
    }



    public void mostrarMenuCrudVehiculosCarga() {
        int opcion = 0;
        do {
            String menu = "═══════════════════════════════════════\n" +
                          "       CRUD VEHÍCULOS DE CARGA\n" +
                          "═══════════════════════════════════════\n\n" +
                          "1. Buscar Vehículo de Carga\n" +
                          "2. Agregar Vehículos de Carga\n" +
                          "3. Obtener Vehículo de Carga\n" +
                          "4. Actualizar Vehículo de Carga\n" +
                          "5. Eliminar Vehículo de Carga\n" +
                          "0. Volver al Menú Principal\n\n" +
                          "Seleccione una opción:";

            String input = JOptionPane.showInputDialog(null, menu, "CRUD Vehículos Carga", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcion) {
                case 1: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga:");
                    if (placa == null || placa.trim().equals("")) break;

                    String res = modelFactory.buscarVehiculoCarga(placa);
                    JOptionPane.showMessageDialog(null, (res == null || res.trim().equals("")) ? "No encontrado." : res);
                    break;
                }
                case 2: {
                    String placa = JOptionPane.showInputDialog("Placa:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String color = JOptionPane.showInputDialog("Color:");
                    String capacidadStr = JOptionPane.showInputDialog("Capacidad de carga (toneladas):");
                    String ejesStr = JOptionPane.showInputDialog("Número de ejes:");

                    if (placa == null || marca == null || modelo == null || color == null ||
                            capacidadStr == null || ejesStr == null ||
                            placa.trim().equals("") || marca.trim().equals("") ||
                            modelo.trim().equals("") || color.trim().equals("") ||
                            capacidadStr.trim().equals("") || ejesStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        double capacidad = Double.parseDouble(capacidadStr);
                        int ejes = Integer.parseInt(ejesStr);
                        boolean ok = modelFactory.agregarVehiculoCarga(placa, marca, modelo, color, capacidad, ejes);
                        JOptionPane.showMessageDialog(null, ok ? "Vehículo de carga agregado." :
                                "Ya existe un vehículo con esa placa.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Capacidad o número de ejes inválidos.");
                    }
                    break;
                }
                case 3: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga:");
                    if (placa == null || placa.trim().equals("")) break;

                    VehiculoCarga v = modelFactory.obtenerVehiculoCarga(placa);
                    JOptionPane.showMessageDialog(null, (v == null) ? "No encontrado." : v.toString());
                    break;
                }
                case 4: {
                    String placa = JOptionPane.showInputDialog("Placa (del vehículo a actualizar):");
                    String marca = JOptionPane.showInputDialog("Nueva marca:");
                    String modelo = JOptionPane.showInputDialog("Nuevo modelo:");
                    String color = JOptionPane.showInputDialog("Nuevo color:");
                    String capacidadStr = JOptionPane.showInputDialog("Nueva capacidad de carga (toneladas):");
                    String ejesStr = JOptionPane.showInputDialog("Nuevo número de ejes:");

                    if (placa == null || marca == null || modelo == null || color == null ||
                            capacidadStr == null || ejesStr == null ||
                            placa.trim().equals("") || marca.trim().equals("") ||
                            modelo.trim().equals("") || color.trim().equals("") ||
                            capacidadStr.trim().equals("") || ejesStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        double capacidad = Double.parseDouble(capacidadStr);
                        int ejes = Integer.parseInt(ejesStr);
                        boolean ok = modelFactory.actualizarVehiculoCarga(placa, marca, modelo, color, capacidad, ejes);
                        JOptionPane.showMessageDialog(null, ok ? "Vehículo de carga actualizado." :
                                "No existe un vehículo de carga con esa placa.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Capacidad o número de ejes inválidos.");
                    }
                    break;
                }
                case 5: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga a eliminar:");
                    if (placa == null || placa.trim().equals("")) break;

                    boolean ok = modelFactory.eliminarVehiculoCarga(placa);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo eliminado." :
                            "No existe un vehículo de carga con esa placa.");
                    break;
                }
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);
    }


    public void mostrarMenuCrudVehiculosTransporte() {
        int opcion = 0;
        do {
            String menu = "═══════════════════════════════════════\n" +
                          "    CRUD VEHÍCULOS DE TRANSPORTE\n" +
                          "═══════════════════════════════════════\n\n" +
                          "1. Buscar Vehículo de Transporte\n" +
                          "2. Agregar Vehículos de Transporte\n" +
                          "3. Obtener Vehículo de Transporte\n" +
                          "4. Actualizar Vehículo de Transporte\n" +
                          "5. Eliminar Vehículo de Transporte\n" +
                          "0. Volver al Menú Principal\n\n" +
                          "Seleccione una opción:";

            String input = JOptionPane.showInputDialog(null, menu, "CRUD Vehículos Transporte", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcion) {
                case 1: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de transporte:");
                    if (placa == null || placa.trim().equals("")) break;

                    String res = modelFactory.buscarVehiculoTransporte(placa);
                    JOptionPane.showMessageDialog(null, (res == null || res.trim().equals("")) ? "No encontrado." : res);
                    break;
                }
                case 2: {
                    String placa = JOptionPane.showInputDialog("Placa:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String color = JOptionPane.showInputDialog("Color:");
                    String maxPasajerosStr = JOptionPane.showInputDialog("Capacidad máxima de pasajeros:");

                    if (placa == null || marca == null || modelo == null || color == null || maxPasajerosStr == null ||
                            placa.trim().equals("") || marca.trim().equals("") ||
                            modelo.trim().equals("") || color.trim().equals("") ||
                            maxPasajerosStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        int maxPasajeros = Integer.parseInt(maxPasajerosStr);
                        boolean ok = modelFactory.agregarVehiculoTransporte(placa, marca, modelo, color, maxPasajeros);
                        JOptionPane.showMessageDialog(null, ok ? "Vehículo de transporte agregado." :
                                "Ya existe un vehículo con esa placa.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Capacidad de pasajeros inválida.");
                    }
                    break;
                }
                case 3: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de transporte:");
                    if (placa == null || placa.trim().equals("")) break;

                    VehiculoTransporte v = modelFactory.obtenerVehiculoTransporte(placa);
                    JOptionPane.showMessageDialog(null, (v == null) ? "No encontrado." : v.toString());
                    break;
                }
                case 4: {
                    String placa = JOptionPane.showInputDialog("Placa (del vehículo a actualizar):");
                    String marca = JOptionPane.showInputDialog("Nueva marca:");
                    String modelo = JOptionPane.showInputDialog("Nuevo modelo:");
                    String color = JOptionPane.showInputDialog("Nuevo color:");
                    String maxPasajerosStr = JOptionPane.showInputDialog("Nueva capacidad máxima de pasajeros:");
                    String usuariosStr = JOptionPane.showInputDialog("Usuarios transportados (total actual):");

                    if (placa == null || marca == null || modelo == null || color == null ||
                            maxPasajerosStr == null || usuariosStr == null ||
                            placa.trim().equals("") || marca.trim().equals("") ||
                            modelo.trim().equals("") || color.trim().equals("") ||
                            maxPasajerosStr.trim().equals("") || usuariosStr.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada o hay campos vacíos.");
                        break;
                    }

                    try {
                        int maxPasajeros = Integer.parseInt(maxPasajerosStr);
                        int usuarios = Integer.parseInt(usuariosStr);
                        boolean ok = modelFactory.actualizarVehiculoTransporte(placa, marca, modelo, color, maxPasajeros, usuarios);
                        JOptionPane.showMessageDialog(null, ok ? "Vehículo de transporte actualizado." :
                                "No existe un vehículo de transporte con esa placa.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valores numéricos inválidos.");
                    }
                    break;
                }
                case 5: {
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de transporte a eliminar:");
                    if (placa == null || placa.trim().equals("")) break;

                    boolean ok = modelFactory.eliminarVehiculoTransporte(placa);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo eliminado." :
                            "No existe un vehículo de transporte con esa placa.");
                    break;
                }
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null,
                    "═════════════════════════════════════════\n" +
                             "         ¡BIENVENIDO!\n" +
                             "      SISTEMA DE TRANSPORTE\n" +
                             "         'LA CARRETA'\n" +
                             "═════════════════════════════════════════\n\n" +
                             "Sistema de gestión con patrón Singleton\n" +
                             "Desarrollado con JOptionPane",
                    "Bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);

            MenuManager menuManager = MenuManager.getInstance();
            menuManager.mostrarMenuPrincipal();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado en la aplicación:\n" + e.getMessage(),
                    "Error Crítico",
                    JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }
}