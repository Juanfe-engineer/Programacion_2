package co.edu.uniquindio.Model;

public class SalonEventoBuilder {
    private String idSalon;
    private String capacidad;
    private boolean estado;
    private String descripcion;

    public SalonEventoBuilder idSalon(String idSalon) {
        this.idSalon = idSalon;
        return this;
    }

    public SalonEventoBuilder capacidad(String capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public SalonEventoBuilder estado(boolean estado) {
        this.estado = estado;
        return this;
    }

    public SalonEventoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }


    public SalonEvento build() {
        return new SalonEvento(idSalon, capacidad, estado, descripcion);
    }

}
