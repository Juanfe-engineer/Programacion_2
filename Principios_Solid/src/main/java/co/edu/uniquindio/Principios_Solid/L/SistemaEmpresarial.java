package co.edu.uniquindio.Principios_Solid.L;

public class SistemaEmpresarial {

    public void procesarAccesoEdificio(PersonaEnEmpresa[] personas) {
        System.out.println("\n PROCESANDO ACCESO AL EDIFICIO");
        System.out.println("================================");
        for(PersonaEnEmpresa persona : personas) {
            persona.entrarEdificio();
        }
    }

    public void procesarNomina(Empleado[] empleados) {
        System.out.println("\n PROCESANDO NOMINA");
        System.out.println("====================");
        double totalNomina = 0;

        for(Empleado empleado : empleados) {
            double salario = empleado.calcularSalario();
            totalNomina += salario;
            System.out.println(empleado.nombre + " (" + empleado.obtenerEstatus() + ") $" + salario);
        }
        System.out.println("\n TOTAL NOMINA: " + totalNomina);
    }

    public void organizarReunionGeneral(PersonaEnEmpresa[] personas) {
        System.out.println("\n REUNION GENERAL DE LA EMPRESA");
        System.out.println("================================");
        for(PersonaEnEmpresa persona : personas) {
            persona.asistirReunion();
        }
    }

    public void gestionarVacaciones (Empleado empleado, int dias) {
        System.out.println("\n GESTION DE VACACIONES");
        System.out.println("=========================");
        empleado.tomarVacaciones(dias);
    }
}

