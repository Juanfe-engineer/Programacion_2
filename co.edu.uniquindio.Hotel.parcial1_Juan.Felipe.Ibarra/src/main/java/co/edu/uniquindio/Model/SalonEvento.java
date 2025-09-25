package co.edu.uniquindio.Model;

public class SalonEvento {
    private String idSalon;
    private String capacidad;
    private boolean estado;
    private String descripcion;


    public SalonEvento(String idSalon, String capacidad,
                       boolean estado, String descripcion) {
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public static SalonEventoBuilder builder(){
        return new SalonEventoBuilder();
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getEstado(boolean estado) {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "SalonEvento{" +
                "idSalon '" + idSalon + '\'' +
                ", capacidad '" + capacidad + '\'' +
                ", estado " + estado +
                ", descripcion '" + descripcion + '\'' +
                '}';
    }
}
