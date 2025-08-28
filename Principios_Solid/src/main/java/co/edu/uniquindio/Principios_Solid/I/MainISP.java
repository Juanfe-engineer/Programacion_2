package co.edu.uniquindio.Principios_Solid.I;

public class MainISP {
    public static void main(String[] args) {
        CentroMultimedia centro = new CentroMultimedia();

        RadioAMFM radio = new RadioAMFM();
        SmartTV TV = new SmartTV();
        Smartphone iphone = new Smartphone("Iphone 15");
        Smartphone Samsung = new Smartphone("Samsung Galaxy");


        ReproductorAudio[] reproductorAudios = {radio,TV,iphone,Samsung};
        centro.configurarAudio(reproductorAudios);

        Pantalla[] pantallas = {TV, iphone, Samsung};
        centro.configurarPantalla(pantallas);

        Camara[] camaras = {iphone, Samsung};
        centro.tomarFotosGrupales(camaras);

        DispositivoTelefono[] telefonos = {iphone, Samsung};
        centro.realizarLlamadaConferencia(telefonos, "+57 300 123 4567");


        System.out.println("========================================================");
        System.out.println("✅ CADA DISPOSITIVO IMPLEMENTA SOLO LO QUE PUEDE HACER");
        System.out.println("✅ NO hay métodos vacíos o excepciones raras");
        System.out.println("✅ EL CÓDIGO ES LIMPIO Y LÓGICO");

    }
}
