package misPaquetes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		try {
			System.out.println("Introduce un número: ");
			int num1 = lector.nextInt();
			
			System.out.println("Introduce otro número: ");
			int num2 = lector.nextInt();
			
			int resultado = num1 / num2;
			System.out.println("El resultado de la división es: " + resultado);
			
		} catch (ArithmeticException e) {
			System.out.println("Error: No se puede dividir entre cero.");
		} catch (InputMismatchException e) {
			System.out.println("Error: Entrada no válida. Por favor, introduce un número entero.");
		} finally {
			lector.close();
			System.out.println("Programa finalizado.");
		}
	}
}

