package co.edu.uniquindio.Principios_Solid.I;

public interface ReproductorAudio {

    void reproducirMusica();
    void pausarMusica();
    void cambiarVolumen(int nivel);
    void obtenerCancionActual();
}
