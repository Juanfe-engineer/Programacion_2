package co.edu.uniquindio.Principios_Solid.O;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones {
    private List<INotificable> notificadores;

    public SistemaNotificaciones(){
        this.notificadores = new ArrayList<>();
    }

    public void agregarNotificador(INotificable notificador){
        notificadores.add(notificador);
    }

    public void EnviarATodos (String mensaje){
        System.out.println("Enviando mensaje a todos los canales....\n");
        for(INotificable notificador : notificadores){
            notificador.enviar(mensaje);
            System.out.println();
        }
    }
}
