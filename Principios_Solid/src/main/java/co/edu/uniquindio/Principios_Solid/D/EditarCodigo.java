package co.edu.uniquindio.Principios_Solid.D;

public class EditarCodigo {
    private ControlVersiones repositorio;
    private String proyectoActual;

    public EditarCodigo(ControlVersiones repositorio, String proyecto) {
        this.repositorio = repositorio;
        this.proyectoActual = proyecto;
        System.out.println("Editor iniciado con " + repositorio.obtenerNombre());
        System.out.println("Proyecto: " + proyecto + "\n");
    }

    public void cambiarRepositorio(ControlVersiones nuevoRepositorio) {
        this.repositorio = nuevoRepositorio;
        System.out.println("Cambiaste a " + nuevoRepositorio.obtenerNombre() + "\n");
    }

    public void escribirCodigo(String archivo, String codigo) {
        System.out.println("Escribiendo código en " + archivo + "...");
        System.out.println("Código: " + codigo);

        repositorio.guardar(archivo, codigo);
        System.out.println();
    }

    public void hacerBackupDelProyecto() {
        System.out.println("Creando backup del proyecto " + proyectoActual + "...");
        String nombreBackup = proyectoActual + "_backup_" + System.currentTimeMillis();
        repositorio.crearRespaldo(nombreBackup);
        System.out.println();
    }

    public void mostrarEstado() {
        System.out.println("Repositorio actual: " + repositorio.obtenerNombre());
        System.out.println("Proyecto: " + proyectoActual);
    }
}
