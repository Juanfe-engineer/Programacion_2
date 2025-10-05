package co.edu.uniquindio.cafeteria.Model.Strategy;

public class MetodoFrances implements MetodoPreparacion{
    @Override
    public String prepararCafe(String tipoCafe, String ingredientes) {
        StringBuilder metodo = new StringBuilder();
        metodo.append("MÉTODO PRENSA FRANCESA:\n\n");
        metodo.append("1. Calentar agua a 93°C\n");
        metodo.append("2. Moler café ").append(tipoCafe.toLowerCase()).append(" grueso\n");
        metodo.append("3. Agregar café a la prensa francesa\n");
        metodo.append("4. Verter agua caliente\n");
        metodo.append("5. Remover suavemente\n");
        metodo.append("6. Colocar tapa y esperar 4 minutos\n");
        metodo.append("7. Presionar émbolo lentamente\n");

        if (ingredientes.contains("Leche")) {
            metodo.append("8. Agregar leche caliente\n");
        }
        if (ingredientes.contains("Azucar")) {
            metodo.append("9. Endulzar al gusto\n");
        }
        if (ingredientes.contains("Whisky")) {
            metodo.append("10. Añadir whisky\n");
        }
        if (ingredientes.contains("Canela")) {
            metodo.append("11. Espolvorear canela\n");
        }

        metodo.append("\n¡Disfrute su café francés!");
        return metodo.toString();
    }
}
