package co.edu.uniquindio.cafeteria.Model;

public class IngredienteDecorator extends Cafe{
    protected Cafe cafe;

    public IngredienteDecorator(Cafe cafe) {
        this.cafe = cafe;
    }


    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }

    @Override
    public double getCosto() {
        return cafe.getCosto();
    }
}
