package misPaquetes;

import java.io.*;
import java.util.*;

public class GestionProductos {

    static final String ARCHIVO = "productos.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                if (opcion == 1) {
                    registrarProducto(scanner);
                } else if (opcion == 2) {
                    mostrarProductos();
                } else if (opcion == 3) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // limpiar entrada errónea
                opcion = 0;
            }

        } while (opcion != 3);

        scanner.close();
    }

    // Método para registrar un nuevo producto
    public static void registrarProducto(Scanner scanner) {
        try {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // limpiar buffer

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine();

            Producto producto = new Producto(nombre, precio, categoria);

            ArrayList<Producto> lista = cargarProductos();
            lista.add(producto);
            guardarProductos(lista);

            System.out.println("Producto registrado correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Datos inválidos. Asegúrate de introducir el precio correctamente.");
            scanner.nextLine(); // limpiar entrada incorrecta
        } catch (IOException e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de clase al cargar productos: " + e.getMessage());
        }
    }

    // Mostrar todos los productos
    public static void mostrarProductos() {
        try {
            ArrayList<Producto> lista = cargarProductos();

            if (lista.isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                System.out.println("\n--- Lista de Productos ---");
                for (Producto p : lista) {
                    System.out.println(p);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
        }
    }

    // Cargar lista desde archivo
    public static ArrayList<Producto> cargarProductos() throws IOException, ClassNotFoundException {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return new ArrayList<>();

        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
        ArrayList<Producto> productos = (ArrayList<Producto>) entrada.readObject();
        entrada.close();
        return productos;
    }

    // Guardar lista en archivo
    public static void guardarProductos(ArrayList<Producto> lista) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
        salida.writeObject(lista);
        salida.close();
    }
}
