package co.edu.uniquindio.TransportCompany_Singleton.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String identificacion;
    private String email;
    private String telefono;
    private int edad;
    private double peso;

    private LinkedList<Vehiculo> vehiculos;

    public Propietario(String nombre, String identificacion, String email, String telefono, int edad,double peso) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.peso = peso;
        this.vehiculos = new LinkedList<>();

    }

    public Propietario() {

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad + '\'' +
                ", peso=" + peso + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
