package co.edu.uniquindio.Principios_Solid.D;

public class GoogleDrive implements ControlVersiones{
    @Override
    public void guardar(String archivo, String contenido) {
        System.out.println("Google Drive: Guardando " + archivo);
        System.out.println("Sincronizando con la nube...");
        System.out.println("Guardado en Google Drive");
    }

    @Override
    public void crearRespaldo(String nombre) {
        System.out.println("Google Drive: Creando carpeta - " + nombre);
    }

    @Override
    public String obtenerNombre() {
        return "GoogleDrive";
    }
}
