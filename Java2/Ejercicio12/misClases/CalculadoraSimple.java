public class CalculadoraSimple {

    int num1 = 20;
    int num2 = 4;
    int resultado;

    public void sumar() {
        resultado = num1 + num2;
        System.out.println("Suma: " + resultado);
    }

    public void restar() {
        resultado = num1 - num2;
        System.out.println("Resta: " + resultado);
    }

    public void multiplicar() {
        resultado = num1 * num2;
        System.out.println("Multiplicación: " + resultado);
    }

    public void dividir() {
        if (num2 != 0) {
            resultado = num1 / num2;
            System.out.println("División: " + resultado);
        } else {
            System.out.println("Error: División por cero no permitida.");
        }
    }

    public static void main(String[] args) {
        CalculadoraSimple calculadora = new CalculadoraSimple();
        calculadora.sumar();
        calculadora.restar();
        calculadora.multiplicar();
        calculadora.dividir();
    }
}
