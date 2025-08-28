package co.edu.uniquindio.Principios_Solid.D;

public class GitLab implements ControlVersiones{
    @Override
    public void guardar(String archivo, String contenido) {
        System.out.println("GitLab: Guardando " + archivo);
        System.out.println("Commit realizado...");
        System.out.println("Desplegando cambios...");
        System.out.println("Guardado en GitLab");
    }

    @Override
    public void crearRespaldo(String nombre) {
        System.out.println("GitLab: Creando snapshot - " + nombre);
    }

    @Override
    public String obtenerNombre() {
        return "GitLab";
    }
}
