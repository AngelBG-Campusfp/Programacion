package com.akihabara.market.view;

import com.akihabara.market.model.ProductoOtaku;
import java.util.List;
import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== Akihabara Market ===");
        System.out.println("1. Añadir producto");
        System.out.println("2. Consultar producto por ID");
        System.out.println("3. Listar todos los productos");
        System.out.println("4. Listar productos por nombre");
        System.out.println("5. Listar productos por categoría");
        System.out.println("6. Actualizar producto");
        System.out.println("7. Eliminar producto");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    public ProductoOtaku pedirDatosProducto(boolean incluirId) {
        try {
            int id = 0;
            if (incluirId) {
                System.out.print("ID del producto: ");
                id = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Stock: ");
            int stock = Integer.parseInt(scanner.nextLine());

            return new ProductoOtaku(id, nombre, categoria, precio, stock);
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida.");
            return null;
        }
    }

    public int pedirId() {
        System.out.print("Ingrese ID: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida.");
            return -1;
        }
    }

    public String pedirNombre() {
        System.out.print("Ingrese nombre: ");
        return scanner.nextLine();
    }

    public String pedirCategoria() {
        System.out.print("Ingrese categoría: ");
        return scanner.nextLine();
    }

    public void mostrarProducto(ProductoOtaku producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
    }

    public void mostrarListaProductos(List<ProductoOtaku> productos) {
        if (productos.isEmpty()) {
            System.out.println("⚠️ No hay productos para mostrar.");
        } else {
            for (ProductoOtaku p : productos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
