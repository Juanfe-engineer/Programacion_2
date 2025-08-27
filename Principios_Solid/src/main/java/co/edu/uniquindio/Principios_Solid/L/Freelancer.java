package co.edu.uniquindio.Principios_Solid.L;

class Freelancer extends Empleado{
    private String proyecto;

    public Freelancer(String nombre, String id, String departamento,
                      double pago,String proyecto) {
        super(nombre,id,departamento,pago,0);
        this.proyecto = proyecto;

    }

    @Override
    public void realizarActividades() {
        System.out.println("Freelancer " + nombre + " trabaja por proyecto");
        System.out.println("Proyecto: " + proyecto);
        System.out.println("Pago del proyecto: $" + salario);
    }

    @Override
    public String obtenerEstatus() {
        return " Freelancer -" + proyecto;
    }
}
