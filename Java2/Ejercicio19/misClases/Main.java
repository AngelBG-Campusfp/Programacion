public class Main {
    public static void main(String[] args) {
      
        int suma = OperacionesBasicas.sumar(8, 5);
        System.out.println("Suma: 8 + 5 = " + suma);

        int resta = OperacionesBasicas.restar(15, 4);
        System.out.println("Resta: 15 - 4 = " + resta);

        int multiplicacion = OperacionesBasicas.multiplicar(6, 7);
        System.out.println("Multiplicación: 6 * 7 = " + multiplicacion);

        double division = OperacionesBasicas.dividir(20, 4);
        System.out.println("División: 20 / 4 = " + division);
    }
}
