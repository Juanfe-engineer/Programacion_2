package co.edu.uniquindio.Principios_Solid.D;

public class SistemaDesarrollo {

    public void simularDiaDeDesarrollo(){
        System.out.println("EMPEZANDO DIA DE DESARROLLO");
        System.out.println("============================\n");

        // Empezamos en github
        EditarCodigo editor = new EditarCodigo(new GitHubMejorado(),"MiAppWeb");

        editor.escribirCodigo("index.html", "<h1>Hola Mundo</h1>");
        editor.escribirCodigo("app.js", "console.log('Funcionando!');");


        // A media mañana decidimos cambiar a GitLab
        System.out.println("El equipo decidio cambiar a GitLab... \n");
        editor.cambiarRepositorio(new GitLab());

        editor.escribirCodigo("styles.css","body { background: blue; }");

        // En la tarde, el internet se va y decidimos usar el disco local
        System.out.println("Se cayo el internet, usando disclo local... \n");
        editor.cambiarRepositorio(new DiscoLocal());

        editor.escribirCodigo("README.md", "# Mi proyecto genial");
        editor.hacerBackupDelProyecto();

        // Al final del dia subimos todo al google drive
        System.out.println("Fin del dia, Backup a Google Drive... \n");
        editor.cambiarRepositorio(new GoogleDrive());

        editor.hacerBackupDelProyecto();

        System.out.println("¡DIA DE DESARROLLO COMPLETADO!");

    }
}
