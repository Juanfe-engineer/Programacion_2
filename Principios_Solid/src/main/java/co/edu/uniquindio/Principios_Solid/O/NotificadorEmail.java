package co.edu.uniquindio.Principios_Solid.O;

public class NotificadorEmail implements INotificable {

    @Override
    public void enviar(String mensaje) {
        System.out.println("Email enviado: " + mensaje);
        System.out.println(" . . . Conectando al servidor . . . ");
        System.out.println("Email entregado correctamente");
    }
}

