package co.edu.uniquindio.Principios_Solid.L;

class Pasante extends PersonaEnEmpresa{
    private String universidad;
    private int duracionMeses;

    public Pasante(String nombre, String id, String departamento,
                   String universidad,int meses){
        super(nombre, id, departamento);
        this.universidad = universidad;
        this.duracionMeses = meses;
    }

    @Override
    public void realizarActividades() {
        System.out.println("Pasante " + nombre + " esta aprendiendo y colaborando");
        System.out.println("Universidad: " + universidad);
        System.out.println("Duracion: " + duracionMeses + " meses");
    }

    @Override
    public String obtenerEstatus() {
        return "Pasante de " + universidad + " (" + duracionMeses + " meses)";
    }

    public void recibirMentoria(){
        System.out.println(nombre + " recibe mentoria de su supervisor");
    }
}

