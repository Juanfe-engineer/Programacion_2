package co.edu.uniquindio.Principios_Solid.I;

public interface DispositivoTelefono {

    void hacerLlamada(String numero);
    void colgarLlamada();
    void enviarSMS(String numero, String mensaje);
}
