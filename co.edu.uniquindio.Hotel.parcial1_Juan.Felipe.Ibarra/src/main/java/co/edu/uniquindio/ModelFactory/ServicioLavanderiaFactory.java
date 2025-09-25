package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.Servicio;
import co.edu.uniquindio.Model.ServicioLavanderia;

public class ServicioLavanderiaFactory extends ServicioFactory{
    @Override
    public Servicio crearServicio(String tipoServicio, boolean premium) {
        System.out.println("LavanderiaFactory: Creando servicio de lavanderia - " + tipoServicio);

        if(premium){
            return new ServicioLavanderia (true,true);
        } else {
            return new ServicioLavanderia (false,false);
        }
    }


    public Servicio crearLavanderiaPredefinida(String tipo) {
        switch (tipo.toLowerCase()) {
            case "express":
                return new ServicioLavanderia(true, false);
            case "completa":
                return new ServicioLavanderia(false, true);
            case "premium":
                return new ServicioLavanderia(true, true);
            case "basica":
            default:
                return new ServicioLavanderia(false, false);
        }
    }
}
