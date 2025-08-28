package co.edu.uniquindio.Principios_Solid.I;

public class Smartphone implements ReproductorAudio,ReproductorVideo,ConexionInternet,
        NavegadorWeb,DispositivoTelefono,Camara,Pantalla{

    private String modelo;
    private boolean llamadaActiva = false;

    public Smartphone(String modelo) {
        this.modelo = modelo;
    }

    // Audio
    @Override
    public void reproducirMusica() {
        System.out.println(modelo + " reproduciendo música");
    }
    @Override
    public void pausarMusica() {
        System.out.println("Música pausada");
    }
    @Override
    public void cambiarVolumen(int nivel) {
        System.out.println("Volumen: " + nivel);
    }
    @Override
    public void obtenerCancionActual() {
        System.out.println("Canción actual en " + modelo);
    }

    // Video
    @Override
    public void reproducirVideo() {
        System.out.println("Reproduciendo video en YouTube");
    }
    @Override
    public void pausarVideo() {
        System.out.println("Video pausado");
    }
    @Override
    public void cambiarBrillo(int nivel) {
        System.out.println("Brillo: " + nivel);
    }
    @Override
    public void cambiarResolucion(int resolucion) {
        System.out.println("Resolucion: " + resolucion);
    }


    // Internet
    @Override
    public void conectarWifi(String red, String password) {
        System.out.println("Conectado a " + red);
    }
    @Override
    public void desconectarWifi() {
        System.out.println("WiFi desconectado");
    }
    @Override
    public boolean estaConectado() {
        return true;
    }

    // Navegador
    @Override
    public void navegarWeb(String url) {
        System.out.println("Abriendo " + url);
    }
    @Override
    public void descargarArchivo(String url) {
        System.out.println("Descargando...");
    }
    @Override
    public void abrirPestana() {
        System.out.println("Nueva pestaña");
    }

    // Teléfono
    @Override
    public void hacerLlamada(String numero) {
        llamadaActiva = true;
        System.out.println("Llamando a " + numero + "...");
    }
    @Override
    public void colgarLlamada() {
        llamadaActiva = false;
        System.out.println("Llamada finalizada");
    }
    @Override
    public void enviarSMS(String numero, String mensaje) {
        System.out.println("SMS a " + numero + ": " + mensaje);
    }

    // Cámara
    @Override
    public void tomarFoto() {
        System.out.println("*click* Foto tomada");
    }
    @Override
    public void grabarVideo() {
        System.out.println("Grabando video...");
    }
    @Override
    public void activarFlash() {
        System.out.println("Flash activado");
    }
    @Override
    public void cambiarCalidad(String calidad) {
        System.out.println("Calidad: " + calidad);
    }

    // Pantalla
    @Override
    public void encender() {
        System.out.println("Pantalla encendida");
    }
    @Override
    public void apagar() {
        System.out.println("Pantalla apagada");
    }
    @Override
    public void mostrarImagen(String imagen) {
        System.out.println("Mostrando: " + imagen);
    }
}

