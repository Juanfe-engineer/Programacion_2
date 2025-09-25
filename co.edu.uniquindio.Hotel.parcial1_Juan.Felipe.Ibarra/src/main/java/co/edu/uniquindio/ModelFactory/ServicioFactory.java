package co.edu.uniquindio.ModelFactory;

import co.edu.uniquindio.Model.Servicio;

public abstract class ServicioFactory {

    public abstract Servicio crearServicio(String parametro1, boolean parametro2);

    public Servicio obtenerServicio(String parametro1, boolean parametro2) {
        System.out.println("Iniciando creacion de servicio...");

        Servicio servicio = crearServicio(parametro1, parametro2);

        configurarServicio(servicio);

        System.out.println("Servicio creado: " +  servicio.getNombre());
        return servicio;
    }

    private void configurarServicio(Servicio servicio) {
        System.out.println("Aplicando configuracion comun al servicio: " + servicio.getTipo());
    }
}
