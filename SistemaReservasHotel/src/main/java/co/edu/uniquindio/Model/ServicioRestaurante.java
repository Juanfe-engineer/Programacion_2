package co.edu.uniquindio.Model;

public class ServicioRestaurante extends Servicio{
    private String tipoMenu;
    private boolean servicioCuarto;

    public ServicioRestaurante(String tipoMenu, boolean servicioCuarto) {
        super("Restaurante - " + tipoMenu, "Restaurante", 45.0,60);
        this.tipoMenu = tipoMenu;
        this.servicioCuarto = servicioCuarto;
        if(servicioCuarto){
            this.precio += 15.0;
        }
    }


    @Override
    public void consumir() {
        System.out.println("Procesando orden del menu: " + tipoMenu);
        tomarOrden();
        preparaComida();
        if(servicioCuarto){
            entregarEnHabitacion();
        } else {
            servirEnRestaurante();
        }
    }

    @Override
    public String getDescripcion() {
        return "Menu " + tipoMenu +
                (servicioCuarto ? " con servicio a cuarto" : " En restaurante");
    }

    private void tomarOrden(){
        System.out.println("Tomando orden del cliente");
    }

    private void preparaComida(){
        System.out.println("Preparando " + tipoMenu);
    }

    private void entregarEnHabitacion(){
        System.out.println("Entregando comida en habitacion");
    }

    private void servirEnRestaurante(){
        System.out.println("Sirviendo en el restaurante");
    }

    // Getters and Setters


    public String getTipoMenu() {
        return tipoMenu;
    }

    public boolean isServicioCuarto() {
        return servicioCuarto;
    }
}
