package misPaquetes;

import java.io.*;
import java.util.Scanner;

public class MensajeArchivo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Escribe una frase: ");
            String frase = entrada.nextLine();

            FileWriter escritor = new FileWriter("mensaje.txt");
            escritor.write(frase + "\n");
            escritor.close();
            System.out.println("Frase guardada correctamente en 'mensaje.txt'.\n");

            File archivo = new File("mensaje.txt");
            Scanner lectorArchivo = new Scanner(archivo);

            System.out.println("Contenido del archivo:");
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                System.out.println(linea);
            }

            lectorArchivo.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir o leer el archivo.");
        }

        entrada.close();
    }
}
