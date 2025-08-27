package co.edu.uniquindio.Principios_Solid.O;

public class NotificadorWhatsApp implements INotificable{

    @Override
    public void enviar(String mensaje) {
        System.out.println("WhatsApp enviado: " + mensaje);
        System.out.println(" . . . Conectando a WhatsApp Bussines API . . . ");
        System.out.println("Mensaje entregado por WhatsApp");
    }
}
