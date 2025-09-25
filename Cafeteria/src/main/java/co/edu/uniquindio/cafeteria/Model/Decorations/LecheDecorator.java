package co.edu.uniquindio.cafeteria.Model.Decorations;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.IngredienteDecorator;

public class LecheDecorator extends IngredienteDecorator {
    public LecheDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Leche";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 0.3;
    }
}
