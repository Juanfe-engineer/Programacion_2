package co.edu.uniquindio.Services;

import co.edu.uniquindio.Model.Cliente;
import co.edu.uniquindio.Model.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioManager {

    public void ejecutarServicios(List<IConsumible> servicios) {
        System.out.println("=== Ejecutando servicios solicitados ===");
        for (IConsumible servicio : servicios) {
            servicio.consumir();
        }
        System.out.println("=== Servicios completados ===");
    }

    public double calcularCostoTotal(List<Servicio> servicios) {
        double total = 0;
        if(servicios != null) {
            for (Servicio servicio : servicios) {
                total += servicio.getPrecio();
            }
        }
        return total;
    }

    public List<Servicio> filtrarPorTipo(List<Servicio> servicios, String tipo) {
        List<Servicio> resultado = new ArrayList<>();
        if (servicios != null && tipo != null) {
            for(Servicio servicio : servicios) {
                if(tipo.equals(servicio.getTipo())) {
                    resultado.add(servicio);
                }
            }
        }
        return resultado;
    }

    public double aplicarDescuentos(List<Servicio> servicios, Cliente cliente) {
        double costoBase = calcularCostoTotal(servicios);

        if(cliente != null && cliente.getReservasActivas().size() >= 2) {
            return costoBase * 0.9;
        }
        return costoBase;
    }
}
