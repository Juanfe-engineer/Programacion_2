package co.edu.uniquindio.cafeteria.Model.Decorations;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.IngredienteDecorator;

public class AzucarDecorator extends IngredienteDecorator {
    public AzucarDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion(){
        return cafe.getDescripcion() + " + Azucar";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 0.2;
    }
}
