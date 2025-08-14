package co.edu.uniquindio.TransportCompany.Model;

public class Propietario {
    private String nombre;
    private String identificacion;
    private String email;
    private String telefono;

    public Propietario(String nombre, String identificacion, String email, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
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

}
