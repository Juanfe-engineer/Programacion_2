package co.edu.uniquindio.Principios_Solid.O;

public class NotificadorDiscord implements INotificable{

    @Override
    public void enviar(String mensaje) {
        System.out.println("Discord enviado: " + mensaje);
        System.out.println(" . . . Conectando a Discord Webhook . . . ");
        System.out.println("Mensaje enviado al canal");
    }
}
