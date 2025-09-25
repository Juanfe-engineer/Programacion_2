package co.edu.uniquindio.Model;

public class ServicioLavanderia extends Servicio{
    private boolean express;
    private boolean planchado;

    public ServicioLavanderia(boolean express, boolean planchado) {
        super("Lavanderia", "Lavanderia",20.0,120);
        this.express = express;
        this.planchado = planchado;

        if(express) this.precio += 10.0;
        if(planchado) this.precio += 8.0;
        if(express) this.duracion += 60;
    }


    @Override
    public void consumir() {
        System.out.println("Procesando servicio de lavanderia");
        recogerRopa();
        lavar();
        if(planchado){
            planchar();
        }
        entregarRopa();
    }

    @Override
    public String getDescripcion() {
        return "Lavanderia" +
                (express ? " express" : "") +
                (planchado ? " planchado" : "");
    }

    private void recogerRopa(){
        System.out.println("Recogiendo ropa de la habitacion");
    }

    private void lavar(){
        System.out.println("Lavando Ropa");
    }

    private void planchar(){
        System.out.println("Planchando Ropa");
    }

    private void entregarRopa(){
        System.out.println("Entregando ropa limpia");
    }

    //Getters and Setters

    public boolean isExpress() {
        return express;
    }

    public boolean isPlanchado() {
        return planchado;
    }

}
