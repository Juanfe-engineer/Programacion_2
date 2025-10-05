package co.edu.uniquindio.cafeteria.Model.Strategy;

public class MetodoFiltrado implements MetodoPreparacion{
    @Override
    public String prepararCafe(String tipoCafe, String ingredientes) {
        StringBuilder metodo = new StringBuilder();
        metodo.append("MÉTODO FILTRADO:\n\n");
        metodo.append("1. Calentar agua a 92-96°C\n");
        metodo.append("2. Colocar filtro de papel en el gotero\n");
        metodo.append("3. Moler café ").append(tipoCafe.toLowerCase()).append(" medio\n");
        metodo.append("4. Agregar café molido al filtro\n");
        metodo.append("5. Verter agua en movimientos circulares\n");
        metodo.append("6. Esperar 3-4 minutos\n");

        if (ingredientes.contains("Leche")) {
            metodo.append("7. Agregar leche caliente\n");
        }
        if (ingredientes.contains("Azucar")) {
            metodo.append("8. Endulzar al gusto\n");
        }
        if (ingredientes.contains("Whisky")) {
            metodo.append("9. Añadir whisky\n");
        }
        if (ingredientes.contains("Canela")) {
            metodo.append("10. Espolvorear canela\n");
        }

        metodo.append("\n¡Disfrute su café filtrado!");
        return metodo.toString();
    }
}
