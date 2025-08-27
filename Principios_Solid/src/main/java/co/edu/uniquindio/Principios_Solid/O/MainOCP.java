package co.edu.uniquindio.Principios_Solid.O;

public class MainOCP {
    public static void main(String[] args) {

        SistemaNotificaciones sistema = new SistemaNotificaciones();

        sistema.agregarNotificador(new NotificadorEmail());
        sistema.agregarNotificador(new NotificadorSMS());
        sistema.agregarNotificador(new NotificadorDiscord());
        sistema.EnviarATodos("¡Tu pedido ha sido enviado!");

        System.out.println("AGREGANDO NUEVOS CANALES SIN MODIFICAR CÓDIGO EXISTENTE");

        sistema.agregarNotificador(new NotificadorWhatsApp());
        sistema.EnviarATodos("¡Nueva funcionalidad disponible!");

    }
}
