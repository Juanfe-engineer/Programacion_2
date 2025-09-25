package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.Servicio;
import co.edu.uniquindio.Model.ServicioSpa;

public class ServicioSpaFactory extends ServicioFactory{


    @Override
    public Servicio crearServicio(String tipoTerapia, boolean incluyeAromaTerapia) {
        System.out.println("SpaFactory: Creando servicio de spa - " + tipoTerapia);

        return new ServicioSpa(tipoTerapia, incluyeAromaTerapia);
    }

    public Servicio crearSpaPredefinido(String tipoSpa){
        switch(tipoSpa.toLowerCase()){
            case "basico":
                return crearServicio("Masaje Relajante", false);
            case "premium":
                return crearServicio("Masaje Terapeutico", true);
            case "Vip":
                return crearServicio("Tratamiento VIP completo", true);
            default:
                return crearServicio("Masaje basico", false);
        }
    }

}
