package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.Servicio;
import co.edu.uniquindio.Model.ServicioHabitacion;
import co.edu.uniquindio.Model.TipoServicioHabitacion;

public class ServicioHabitacionFactory extends ServicioFactory{

    @Override
    public Servicio crearServicio(String tipoServicio, boolean premium) {
        System.out.println("HabitacionFactory: Creando servicio de habitacion - " + tipoServicio);

        TipoServicioHabitacion tipo;
        String nombre;
        double precio;

        if(premium){
            tipo = TipoServicioHabitacion.MANTENIMIENTO;
            nombre = "Mantenimiento";
            precio = 50.0;
        } else {
            tipo = TipoServicioHabitacion.LIMPIEZA;
            nombre = "Limpieza";
            precio = 30.0;
        }
        return new ServicioHabitacion(nombre, precio, tipo);
    }
}
