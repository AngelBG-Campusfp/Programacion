package misPaquetes;

import java.io.*;
import java.util.Scanner;

public class Suma {

    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("numeros.txt");
            escritor.write("10\n");
            escritor.write("25\n");
            escritor.write("-5\n");
            escritor.write("hola\n");  
            escritor.write("30\n");
            escritor.write("100\n");
            escritor.close();
            System.out.println("Archivo 'numeros.txt' creado con numeros de ejemplo.\n");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
            return; 
        }

        int suma = 0;

        try {
            File archivo = new File("numeros.txt");
            Scanner lector = new Scanner(archivo);

            System.out.println("Sumando numeros...");
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                try {
                    int numero = Integer.parseInt(linea);
                    suma += numero;
                } catch (NumberFormatException e) {
                    System.out.println("Línea no válida: " + linea);
                }
            }

            lector.close();
            System.out.println("\nSuma total de los numeros: " + suma);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

