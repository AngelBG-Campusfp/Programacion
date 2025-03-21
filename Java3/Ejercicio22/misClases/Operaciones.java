public class Operaciones {
    int num1 = 115;
    int num2 = 5;
    int resultado;

    public void realizarOperaciones() {
        resultado = num1 + num2;
        System.out.println("Suma: " + resultado);

        resultado = num1 - num2;
        System.out.println("Resta: " + resultado);

        resultado = num1 * num2;
        System.out.println("Multiplicación: " + resultado);

        resultado = num1 / num2;
        System.out.println("División: " + resultado);
    }

    public static void main(String[] args) {
        Operaciones opera = new Operaciones();
        opera.realizarOperaciones();
    }
}