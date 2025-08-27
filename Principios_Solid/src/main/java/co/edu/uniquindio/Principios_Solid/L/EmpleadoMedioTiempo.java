package co.edu.uniquindio.Principios_Solid.L;

class EmpleadoMedioTiempo extends Empleado{
    public EmpleadoMedioTiempo(String nombre,String id,String departamento,double salario){
        super(nombre,id,departamento,salario,15);
    }

    @Override
    public void realizarActividades() {
        System.out.println("Empleado " + nombre + " trabaja 20 horas semanales");
        System.out.println("Salario: $" + salario);
    }

    @Override
    public String obtenerEstatus() {
        return "Empleado medio tiempo";
    }
}

