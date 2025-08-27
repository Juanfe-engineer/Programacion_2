package co.edu.uniquindio.Principios_Solid.L;

abstract class Empleado extends PersonaEnEmpresa{
    protected double salario;
    protected int diasVacaciones;

    public Empleado(String nombre, String id, String departamento,
                    double salario, int diasVacaciones) {
        super(nombre, id, departamento);
        this.salario = salario;
        this.diasVacaciones = diasVacaciones;
    }

    public double calcularSalario() {
        return salario;
    }

    public void tomarVacaciones(int dias) {
        if (dias <= diasVacaciones) {
            diasVacaciones -= dias;
            System.out.println(nombre + " se va " + dias + " dias de vacaciones");
            System.out.println(" Le quedan " + diasVacaciones + " dias de vacaciones");
        } else {
            System.out.println(nombre + " no tiene suficientes dias de vacaciones");
        }
    }
}

