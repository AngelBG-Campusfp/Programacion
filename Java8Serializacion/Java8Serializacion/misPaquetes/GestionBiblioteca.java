package misPaquetes;

import java.io.*;
import java.util.*;

public class GestionBiblioteca {
    static final String ARCHIVO = "biblioteca.ser";
    static ArrayList<Libro> biblioteca = new ArrayList<>();

    public static void main(String[] args) {
        cargar();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("-------- MENÚ PRINCIPAL --------");
            System.out.println("-- 1. Añadir libro --");
            System.out.println("-- 2. Mostrar libros --");
            System.out.println("-- 3. Buscar libro --");
            System.out.println("-- 4. Salir --");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> añadir(sc);
                case 2 -> mostrar();
                case 3 -> buscar(sc);
                case 4 -> guardar();
                default -> System.out.println("Opción inválida");
            }
        } while (op != 4);
    }

    static void añadir(Scanner sc) {
        System.out.print("Título: "); String t = sc.nextLine();
        System.out.print("Autor: "); String a = sc.nextLine();
        System.out.print("ISBN: "); String i = sc.nextLine();
        System.out.print("Año: "); int y = Integer.parseInt(sc.nextLine());

        for (Libro l : biblioteca)
            if (l.ISBN.equalsIgnoreCase(i)) {
                System.out.println("ISBN repetido.");
                return;
            }

        biblioteca.add(new Libro(t, a, i, y));
        guardar();
        System.out.println("Libro añadido.");
    }

    static void mostrar() {
        if (biblioteca.isEmpty()) System.out.println("No hay libros.");
        else biblioteca.forEach(System.out::println);
    }

    static void buscar(Scanner sc) {
        System.out.print("Buscar: "); String q = sc.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Libro l : biblioteca)
            if (l.Libro.toLowerCase().contains(q) || l.Libro.toLowerCase().contains(q)) {
                System.out.println(l);
                encontrado = true;
            }

        if (!encontrado) System.out.println("No encontrado.");
    }

    static void guardar() {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            o.writeObject(biblioteca);
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    static void cargar() {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            biblioteca = (ArrayList<Libro>) o.readObject();
        } catch (Exception ignored) {}
    }
}
