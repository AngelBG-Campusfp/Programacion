package misPaquetes;

import java.io.*;
import java.util.*;

public class GestorNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestor de Notas ---");
            System.out.println("1. Crear nueva nota");
            System.out.println("2. Leer todas las notas");
            System.out.println("3. Eliminar una nota");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        crearNota(scanner);
                        break;
                    case 2:
                        leerNotas();
                        break;
                    case 3:
                        eliminarNota(scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del gestor...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }

    // Crear nueva nota
    public static void crearNota(Scanner scanner) {
        try {
            System.out.print("Título de la nota (sin espacios): ");
            String titulo = scanner.nextLine();

            System.out.println("Contenido de la nota:");
            String contenido = scanner.nextLine();

            Nota nota = new Nota(titulo, contenido);
            nota.guardarEnArchivo();
            System.out.println("Nota guardada como '" + titulo + ".txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar la nota: " + e.getMessage());
        }
    }

    // Leer todas las notas (.txt)
    public static void leerNotas() {
        File carpeta = new File(".");
        File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.endsWith(".txt"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay notas guardadas.");
            return;
        }

        System.out.println("\n--- Notas encontradas ---");
        for (File archivo : archivos) {
            System.out.println("\nNota: " + archivo.getName());
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer la nota " + archivo.getName());
            }
        }
    }

    // Eliminar una nota
    public static void eliminarNota(Scanner scanner) {
        System.out.print("Nombre del archivo de la nota a eliminar (sin .txt): ");
        String nombre = scanner.nextLine();
        File archivo = new File(nombre + ".txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Nota '" + nombre + ".txt' eliminada.");
            } else {
                System.out.println("No se pudo eliminar la nota.");
            }
        } else {
            System.out.println("La nota no existe.");
        }
    }
}