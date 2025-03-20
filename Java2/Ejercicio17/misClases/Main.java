public class Main {
    public static void main(String[] args) {
        Circunferencia circun = new Circunferencia();
        
        double radio = 5.0;
        double resultado = circun.calcularCircunferencia(radio);
        
        System.out.println("La circunferencia del círculo de radio " + radio + 	" es: " + resultado);
    }
}
