package co.edu.uniquindio.cafeteria.Model;

public class CafeSimple extends Cafe {
    private String tipo;

    public CafeSimple(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDescripcion() {
        return "Café " + tipo.toLowerCase();
    }

    @Override
    public double getCosto() {
        switch (tipo.toLowerCase()) {
            case "especial":
                return 2.0;
            case "pasilla":
                return 1.5;
            default:
                return 2.0;
        }
    }

    public String getTipo() {
        return tipo;
    }
}
