package co.edu.uniquindio.Model;

import co.edu.uniquindio.Services.IConsumible;

public abstract class Servicio implements IConsumible {
    protected String nombre;
    protected String tipo;
    protected double precio;
    protected int duracion; // en minutos

    public Servicio(String nombre, String tipo, double precio, int duracion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.duracion = duracion;
    }

    public void ejecutarServicio() {
        iniciar();
        consumir();
        finalizar();
    }

    protected void iniciar() {
        System.out.println("Iniciando servicio " + nombre);
    }

    protected void finalizar() {
        System.out.println("Finalizando servicio " + nombre);
    }

    @Override
    public abstract void consumir();

    //Getters and Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - $" + precio;
    }
}
