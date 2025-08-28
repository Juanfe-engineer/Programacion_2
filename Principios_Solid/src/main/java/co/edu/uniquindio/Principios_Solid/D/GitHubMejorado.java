package co.edu.uniquindio.Principios_Solid.D;

public class GitHubMejorado implements ControlVersiones{

    @Override
    public void guardar(String archivo, String contenido) {
        System.out.println("GitHub: Guardando " + archivo);
        System.out.println("Haciendo commit... ");
        System.out.println("Subiendo a la nube...");
        System.out.println("Guardado en GitHub");
    }

    @Override
    public void crearRespaldo(String nombre) {
        System.out.println("GitHub: creando branch de respaldo - " + nombre);
    }

    @Override
    public String obtenerNombre() {
        return "GitHub";
    }


}
