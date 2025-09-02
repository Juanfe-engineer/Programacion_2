package co.edu.uniquindio.Model;

public class ServicioHabitacion extends Servicio{
    private TipoServicioHabitacion tipoServicioHabitacion;

    public ServicioHabitacion(String nombre, double precio, TipoServicioHabitacion tipoServicioHabitacion) {
        super(nombre,"Habitacion",precio,30);
        this.tipoServicioHabitacion = tipoServicioHabitacion;
    }


    @Override
    public void consumir() {
        System.out.println("Ejecutando servicio de habitacion: " + tipoServicioHabitacion);
        realizarServicio();
    }

    @Override
    public String getDescripcion() {
        return "Servicio de " + tipoServicioHabitacion + " en habitacion";
    }

    private void realizarServicio(){
        System.out.println("Realizando " + tipoServicioHabitacion + " en la habitacion");
    }

    //Getters and Setters


    public TipoServicioHabitacion getTipoServicioHabitacion() {
        return tipoServicioHabitacion;
    }

    public void setTipoServicioHabitacion(TipoServicioHabitacion tipoServicioHabitacion) {
        this.tipoServicioHabitacion = tipoServicioHabitacion;
    }
}
