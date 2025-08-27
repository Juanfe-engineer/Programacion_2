package co.edu.uniquindio.Principios_Solid.L;

public class MainLSP {
    public static void main(String[] args) {
        SistemaEmpresarial sistema = new SistemaEmpresarial();

        PersonaEnEmpresa[] personas = {
                new EmpleadoTiempoCompleto("Ana Garcia","EMP001", "Desarrollo",3000.00),
                new EmpleadoMedioTiempo("Luis Rodriguez", "EMP002", "Marketing",1500.00),
                new Freelancer("Carlos Mendez", "FREE001", "Diseño", 2000.00,"Rediseño web"),
                new Pasante("Juan Felipe", "PAS001", "Desarrollo","Universidad del Quindio",6)
        };


        Empleado[] empleados = {
                (EmpleadoTiempoCompleto) personas[0],
                (EmpleadoMedioTiempo) personas[1],
                (Freelancer) personas[2],
        };

        sistema.procesarAccesoEdificio(personas);
        sistema.organizarReunionGeneral(personas);

        sistema.procesarNomina(empleados);
        sistema.gestionarVacaciones(empleados[0],5 );

        System.out.println("\n" + "=".repeat(35));
        System.out.println("El sistema funciona perfectamente:");
        System.out.println("Los pasantes participan en lo que pueden");
        System.out.println("Los empleados tienen todos sus beneficios");


    }
}
