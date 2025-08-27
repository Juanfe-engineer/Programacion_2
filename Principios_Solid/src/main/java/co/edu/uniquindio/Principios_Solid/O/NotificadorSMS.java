package co.edu.uniquindio.Principios_Solid.O;

public class NotificadorSMS implements INotificable{

    @Override
    public void enviar(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
        System.out.println(" . . . Conectando a la API de SMS . . . ");
        System.out.println("SMS entregado al operador");
    }
}
