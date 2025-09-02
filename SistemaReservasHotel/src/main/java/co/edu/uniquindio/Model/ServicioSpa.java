package co.edu.uniquindio.Model;

public class ServicioSpa extends Servicio{
    private String tipoTerapia;
    private boolean incluyeAromaTerapia;

    public ServicioSpa(String tipoTerapia) {
        super("Spa - " + tipoTerapia,"Spa",75.0,90);
        this.tipoTerapia = tipoTerapia;
        this.incluyeAromaTerapia = false;
    }

    public ServicioSpa(String tipoTerapia, boolean incluyeAromaTerapia) {
        this(tipoTerapia);
        this.incluyeAromaTerapia = incluyeAromaTerapia;
        if(incluyeAromaTerapia){
            this.precio += 25.0;
        }
    }


    @Override
    public void consumir() {
        System.out.println("Iniciando sesion de spa: " + tipoTerapia);
        prepararAmbiente();
        aplicarTerapia();
        if(incluyeAromaTerapia){
            aplicarAromaTerapia();
        }
        System.out.println("Sesion de spa completada");
    }

    @Override
    public String getDescripcion() {
        return "Terapia de " + tipoTerapia +
                (incluyeAromaTerapia ? " con aromaterapia" : "");
    }

    private void prepararAmbiente() {
        System.out.println("Preparando ambiente relajante...");
    }

    private void aplicarTerapia(){
        System.out.println("Aplicando " + tipoTerapia);
    }

    private void aplicarAromaTerapia(){
        System.out.println("Aplicando aromaterapia complementaria");
    }


    //Getters and Setters

    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public boolean isIncluyeAromaTerapia() {
        return incluyeAromaTerapia;
    }
}
