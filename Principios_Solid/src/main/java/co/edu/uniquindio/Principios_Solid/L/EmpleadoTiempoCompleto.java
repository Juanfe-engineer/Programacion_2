package co.edu.uniquindio.Principios_Solid.L;

class EmpleadoTiempoCompleto extends Empleado {
    public EmpleadoTiempoCompleto(String nombre, String id, String departamento, double salario) {
        super(nombre,id,departamento,salario,30);
    }

    @Override
    public void realizarActividades() {
        System.out.println("Empleado " + nombre + " trabaja 40 horas semanales");
        System.out.println(" Salario: $" + salario);
    }

    @Override
    public String obtenerEstatus() {
        return "Empleado tiempo completo";
    }
}
