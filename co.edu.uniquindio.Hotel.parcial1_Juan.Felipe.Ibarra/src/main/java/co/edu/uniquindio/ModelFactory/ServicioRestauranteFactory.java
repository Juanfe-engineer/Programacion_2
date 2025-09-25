package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.Servicio;
import co.edu.uniquindio.Model.ServicioRestaurante;

public class ServicioRestauranteFactory extends ServicioFactory{
    @Override
    public Servicio crearServicio(String tipoMenu, boolean servicioCuarto) {
        System.out.println("RestauranteFactory: Creando servicio de restaurante - " + tipoMenu);

        return new ServicioRestaurante(tipoMenu, servicioCuarto);
    }

    public Servicio crearMenuPredefinido(String tipoMenu){
        switch (tipoMenu.toLowerCase()){
            case "desayuno":
                return crearServicio("Desayuno Continental",true);
            case "almuerzo":
                return crearServicio("Almuerzo Ejecutivo",false);
            case "cena":
                return crearServicio("Cena Gourmet",true);
            case "vip":
                return crearServicio("Menu VIP Exclusivo",true);
            default:
                return crearServicio("Menu del dia",false);
        }
    }

}
