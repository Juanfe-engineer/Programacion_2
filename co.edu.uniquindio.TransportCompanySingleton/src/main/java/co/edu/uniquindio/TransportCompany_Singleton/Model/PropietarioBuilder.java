package co.edu.uniquindio.TransportCompany_Singleton.Model;

public class PropietarioBuilder {
    private String nombre;
    private String identificacion;
    private String email;
    private String telefono;
    private int edad;
    private double peso;


    public PropietarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public PropietarioBuilder setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }
    public PropietarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    public PropietarioBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }
    public PropietarioBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }
    public PropietarioBuilder setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public Propietario build() {
        return new Propietario(nombre, identificacion, email, telefono, edad, peso);
    }
}
