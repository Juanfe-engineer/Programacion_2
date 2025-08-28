package co.edu.uniquindio.Principios_Solid.D;

public class DiscoLocal implements ControlVersiones{
    @Override
    public void guardar(String archivo, String contenido) {
        System.out.println("Disco Local: Guardando " + archivo);
        System.out.println("Escribiendo archivo...");
        System.out.println("Guardado en disco local");
    }

    @Override
    public void crearRespaldo(String nombre) {
        System.out.println("Disco Local: Creando carpeta - " + nombre);
    }

    @Override
    public String obtenerNombre() {
        return " Disco Local";
    }
}
