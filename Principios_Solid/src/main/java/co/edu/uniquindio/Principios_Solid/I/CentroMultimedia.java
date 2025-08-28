package co.edu.uniquindio.Principios_Solid.I;

public class CentroMultimedia {

    public void configurarAudio(ReproductorAudio[] dispositivos) {
        System.out.println("CONFIGURANDO REPRODUCTORES DE AUDIO");
        System.out.println("===================================");
        for(ReproductorAudio dispositivo : dispositivos) {
            dispositivo.cambiarVolumen(75);
            dispositivo.reproducirMusica();
        }
    }

    public void configurarPantalla(Pantalla[] pantallas) {
        System.out.println("\n CONFIGURANDO PANTALLAS");
        System.out.println("=========================");
        for(Pantalla pantalla : pantallas) {
            pantalla.encender();
            pantalla.mostrarImagen("Logo de una empresa...");
        }
    }

    public void tomarFotosGrupales(Camara[] camaras){
        System.out.println("\n SESION FOTOGRAFICA");
        System.out.println("=====================");
        for(Camara camara : camaras){
            camara.activarFlash();
            camara.cambiarCalidad("4K");
            camara.tomarFoto();
        }
    }


    public void realizarLlamadaConferencia(DispositivoTelefono[] telefonos, String numero){
        System.out.println("\n LLAMADA CONFERENCIA");
        System.out.println("======================");
        for(DispositivoTelefono dispositivo : telefonos){
            dispositivo.hacerLlamada(numero);
        }
    }



}
