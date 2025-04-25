package misPaquetes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {

    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formato);

        try {
            FileWriter escritor = new FileWriter("historial.txt", true); // modo append
            escritor.write("Ejecución: " + fechaHora + "\n");
            escritor.close();
            System.out.println("Historial actualizado: " + fechaHora);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
