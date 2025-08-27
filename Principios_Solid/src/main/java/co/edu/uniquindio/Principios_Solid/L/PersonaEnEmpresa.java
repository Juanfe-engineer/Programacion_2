package co.edu.uniquindio.Principios_Solid.L;

abstract class PersonaEnEmpresa {
    protected String nombre;
    protected String id;
    protected String departamento;

    public PersonaEnEmpresa(String nombre, String id, String departamento) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
    }

    public void entrarEdificio() {
        System.out.println(nombre + " entra al edificio con tarjeta " + id);
    }

    public void usarComedor() {
        System.out.println(nombre + " usa el comedor de la empresa ");
    }

    public void asistirReunion() {
        System.out.println(nombre + " asiste a reunion del departamento de " + departamento);
    }


    public abstract void realizarActividades();
    public abstract String obtenerEstatus();
}
