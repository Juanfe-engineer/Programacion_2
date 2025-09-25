package co.edu.uniquindio.cafeteria.Model.Decorations;

import co.edu.uniquindio.cafeteria.Model.Cafe;
import co.edu.uniquindio.cafeteria.Model.IngredienteDecorator;

public class CanelaDecorator extends IngredienteDecorator {
    public CanelaDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Canela";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 0.2;
    }
}
