package co.edu.uniquindio.Principios_Solid.S;

public class MainSRP {
    public static void main(String[] args) {

        Calculadora calcular = new Calculadora();
        ImprimirResultados imprimir = new ImprimirResultados();
        GuardarResultados guardarResultados = new GuardarResultados();

        int resultado = calcular.sumar(10,5);
        imprimir.mostrarResultados("+ ", 10, 5, resultado);
        guardarResultados.guardar("Suma: " + resultado);

        System.out.println("-----------------------------------");

        int resultado2 = calcular.multiplicar(7,4);
        imprimir.mostrarResultados("* ", 7, 4, resultado2);
        guardarResultados.guardar("Multiplicacion: " + resultado2);

        System.out.println("-----------------------------------");

        int resultado3 = calcular.restar(15,8);
        imprimir.mostrarResultados("- ", 15, 8, resultado3);
        guardarResultados.guardar("Resta: " + resultado3);
    }

}
