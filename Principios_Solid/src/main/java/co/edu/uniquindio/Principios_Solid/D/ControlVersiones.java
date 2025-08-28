package co.edu.uniquindio.Principios_Solid.D;

public interface ControlVersiones {
    void guardar (String archivo, String contenido);
    void crearRespaldo (String nombre);
    String obtenerNombre();
}
