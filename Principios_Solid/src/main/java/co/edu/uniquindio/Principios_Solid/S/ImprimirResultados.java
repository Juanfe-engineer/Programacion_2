package co.edu.uniquindio.Principios_Solid.S;

public class ImprimirResultados {

    public void mostrarResultados (String operacion, int a,
                                   int b, int resultado) {

        System.out.println("El resultado de " + a + " " +
                operacion + b + " = " + resultado);
    }
}
