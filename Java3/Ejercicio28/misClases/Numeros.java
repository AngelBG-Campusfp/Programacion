public class Numeros {
    public static void main(String[] args) {
        int suma = 0;
        int numero = 5; 

        do {
            System.out.println("Ingresa un número (0 para terminar): " + numero);
            suma += numero;
            numero = 0; 
        } while (numero != 0);

        System.out.println("La suma total es: " + suma);
    }
}