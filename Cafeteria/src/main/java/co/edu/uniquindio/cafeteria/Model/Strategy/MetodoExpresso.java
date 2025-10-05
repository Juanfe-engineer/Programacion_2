package co.edu.uniquindio.cafeteria.Model.Strategy;

public class MetodoExpresso implements MetodoPreparacion{
    @Override
    public String prepararCafe(String tipoCafe, String ingredientes) {
        StringBuilder metodo = new StringBuilder();
        metodo.append("MÉTODO ESPRESSO:\n\n");
        metodo.append("1. Calentar la máquina de espresso\n");
        metodo.append("2. Moler café ").append(tipoCafe.toLowerCase()).append(" fino\n");
        metodo.append("3. Compactar el café en el portafiltro\n");
        metodo.append("4. Extraer espresso (25-30 segundos)\n");

        if (ingredientes.contains("Leche")) {
            metodo.append("5. Vaporizar leche hasta 65°C\n");
            metodo.append("6. Verter leche sobre el espresso\n");
        }
        if (ingredientes.contains("Azucar")) {
            metodo.append("7. Endulzar al gusto\n");
        }
        if (ingredientes.contains("Whisky")) {
            metodo.append("8. Añadir whisky\n");
        }
        if (ingredientes.contains("Canela")) {
            metodo.append("9. Espolvorear canela\n");
        }

        metodo.append("\n¡Disfrute su espresso!");
        return metodo.toString();
    }
}
