package co.edu.uniquindio.Services;

import co.edu.uniquindio.Model.Servicio;
import co.edu.uniquindio.ModelFactory.ServicioHabitacionFactory;
import co.edu.uniquindio.ModelFactory.ServicioLavanderiaFactory;
import co.edu.uniquindio.ModelFactory.ServicioRestauranteFactory;
import co.edu.uniquindio.ModelFactory.ServicioSpaFactory;

import java.util.ArrayList;
import java.util.List;

public class ServicioFactoryManager {
    private ServicioSpaFactory spaFactory;
    private ServicioRestauranteFactory restauranteFactory;
    private ServicioLavanderiaFactory lavanderiaFactory;
    private ServicioHabitacionFactory habitacionFactory;

    public ServicioFactoryManager() {
        this.spaFactory = new ServicioSpaFactory();
        this.restauranteFactory = new ServicioRestauranteFactory();
        this.lavanderiaFactory = new ServicioLavanderiaFactory();
        this.habitacionFactory = new ServicioHabitacionFactory();
    }

    public List<Servicio> crearPaqueteServicios(String tipoHabitacion) {
        List<Servicio> paquete = new ArrayList<>();

        System.out.println("== Creando paquete para habitacion " + tipoHabitacion + " ==");

        switch (tipoHabitacion.toLowerCase()) {
            case "suite":
                paquete.add(spaFactory.crearSpaPredefinido("vip"));
                paquete.add(restauranteFactory.crearMenuPredefinido("vip"));
                paquete.add(lavanderiaFactory.crearLavanderiaPredefinida("premium"));
                paquete.add(habitacionFactory.crearServicio("Mantenimiento",true));
                break;

            case "doble":
                paquete.add(spaFactory.crearSpaPredefinido("premium"));
                paquete.add(restauranteFactory.crearMenuPredefinido("cena"));
                paquete.add(lavanderiaFactory.crearLavanderiaPredefinida("express"));
                paquete.add(habitacionFactory.crearServicio("Mantenimiento", true));
                break;

            case "simple":
                paquete.add(restauranteFactory.crearMenuPredefinido("desayuno"));
                paquete.add(habitacionFactory.crearServicio("Limpieza", true));
                break;

            default:
                System.out.println("Tipo de habitacion no reconocido, creando paquete basico");
                paquete.add(habitacionFactory.crearServicio("Limpieza",true));
        }
        System.out.println("Paquete creado con " + paquete.size() + " servicios");
        return paquete;
    }

    public List<Servicio> crearServiciosVIP(int numeroReservas) {
        List<Servicio> serviciosVIP = new ArrayList<>();


        Servicio spaVIP = spaFactory.crearServicio("Tratamiento VIP", true);
        spaVIP.setPrecio(spaVIP.getPrecio() * 0.5);

        Servicio restauranteVIP = restauranteFactory.crearServicio("Menu VIP Exclusivo", true);
        restauranteVIP.setPrecio(restauranteVIP.getPrecio() * 0.3);

        serviciosVIP.add(spaVIP);
        serviciosVIP.add(restauranteVIP);

        return serviciosVIP;
    }
}
