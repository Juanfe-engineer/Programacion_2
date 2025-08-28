package co.edu.uniquindio.Principios_Solid.I;

public class RadioAMFM implements ReproductorAudio{
    private String estacionActual = "Rock 101.05";
    private int volumen = 50;


    @Override
    public void reproducirMusica() {
        System.out.println("Sintonizando " + estacionActual);
        System.out.println("Reproduccion musica... ");
    }

    @Override
    public void pausarMusica() {
        System.out.println("Radio pausada (silenciada)");
    }

    @Override
    public void cambiarVolumen(int nivel) {
        this.volumen = nivel;
        System.out.println("Volumen de radio ajustado a: " + nivel);
    }

    @Override
    public void obtenerCancionActual() {
        System.out.println(" Estacion actual: " + estacionActual);
    }


    public void cambiarEstacion(String estacion) {
        this.estacionActual = estacion;
        System.out.println("Cambiando a estacion " + estacion);
    }
}
