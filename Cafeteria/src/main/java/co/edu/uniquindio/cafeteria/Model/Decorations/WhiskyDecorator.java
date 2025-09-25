package co.edu.uniquindio.cafeteria.Model.Decorations;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.IngredienteDecorator;

public class WhiskyDecorator extends IngredienteDecorator {
    public WhiskyDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Whisky";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 0.5;
    }

}
