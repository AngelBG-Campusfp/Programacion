import operaciones.Multiplicador;

public class Main {
    public static void main(String[] args) {
        Multiplicador multi = new Multiplicador();  
        int resultado = multi.multiplicar(6,5);
	System.out.println("Resultado: " + resultado);
    }
}