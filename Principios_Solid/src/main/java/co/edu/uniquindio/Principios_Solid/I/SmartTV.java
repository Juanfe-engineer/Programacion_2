package co.edu.uniquindio.Principios_Solid.I;

public class SmartTV implements ReproductorAudio,ReproductorVideo,ConexionInternet,
        NavegadorWeb,Pantalla {

    private boolean encendido = false;
    private String contenidoActual = "";

    //Implementacion de ConexionInternet

    @Override
    public void conectarWifi(String red, String password) {
        System.out.println(" TV Conectandose a WiFi: " + red);
        System.out.println(" TV Conectada a internet");
    }

    @Override
    public void desconectarWifi() {
        System.out.println("Tv desconectada de WiFi");
    }

    @Override
    public boolean estaConectado() {
        return true;
    }

    //Implementacion de NavegadorWeb

    @Override
    public void navegarWeb(String url) {
        System.out.println(" TV Navegando a: " + url);
    }

    @Override
    public void descargarArchivo(String url) {
        System.out.println(" TV Descargando a: " + url);
    }

    @Override
    public void abrirPestana() {
        System.out.println(" Nueva pestaña abierta en TV");
    }

    //Implementacion de Pantalla

    @Override
    public void encender() {
        encendido = true;
        System.out.println("TV Encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println(" TV Apagada");
    }

    @Override
    public void mostrarImagen(String imagen) {
        System.out.println("Mostrando en pantalla: " + imagen);
    }

   // Implementacion ReproductorAudio

    @Override
    public void reproducirMusica() {
        System.out.println("TV reproduciendo musica a traves de Spotify");
    }

    @Override
    public void pausarMusica() {
        System.out.println("Musica pausada en TV");
    }

    @Override
    public void cambiarVolumen(int nivel) {
        System.out.println("Volumen de TV " + nivel);
    }

    @Override
    public void obtenerCancionActual() {
        System.out.println("Reproduciendo en TV " + contenidoActual);
    }

    // Implementacion de ReproductorVideo

    @Override
    public void reproducirVideo() {
        contenidoActual = "Netflix - Stranger Things";
        System.out.println("TV reproduciendo " + contenidoActual);
    }

    @Override
    public void pausarVideo() {
        System.out.println("Video pausado en TV");
    }

    @Override
    public void cambiarBrillo(int nivel) {
        System.out.println("Brillo de TV ajustado a: " + nivel);
    }

    @Override
    public void cambiarResolucion(int resolucion) {
        System.out.println("Resolucion cambiada a: " + resolucion);
    }
}
