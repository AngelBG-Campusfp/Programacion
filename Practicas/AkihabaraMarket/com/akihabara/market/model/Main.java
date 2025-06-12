package com.akihabara.market.model;

import com.akihabara.market.dao.ProductoDAO;
import com.akihabara.market.view.InterfazConsola;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfazConsola vista = new InterfazConsola();
        ProductoDAO dao = new ProductoDAO();

        // Producto de prueba (opcional)
        ProductoOtaku productoEjemplo = new ProductoOtaku(1, "Figura Naruto", "Figura", 29.99, 15);
        vista.mostrarMensaje("Producto de prueba creado:");
        vista.mostrarProducto(productoEjemplo);

        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1 -> {
                    ProductoOtaku nuevo = vista.pedirDatosProducto(false);
                    if (nuevo != null) dao.agregarProducto(nuevo);
                }
                case 2 -> {
                    int id = vista.pedirId();
                    ProductoOtaku p = dao.obtenerProductoPorId(id);
                    vista.mostrarProducto(p);
                }
                case 3 -> {
                    List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();
                    vista.mostrarListaProductos(productos);
                }
                case 4 -> {
                    String nombre = vista.pedirNombre();
                    List<ProductoOtaku> porNombre = dao.buscarProductosPorNombre(nombre);
                    vista.mostrarListaProductos(porNombre);
                }
                case 5 -> {
                    String categoria = vista.pedirCategoria();
                    List<ProductoOtaku> porCat = dao.buscarProductoPorCategoria(categoria);
                    vista.mostrarListaProductos(porCat);
                }
                case 6 -> {
                    int id = vista.pedirId();
                    ProductoOtaku existente = dao.obtenerProductoPorId(id);
                    if (existente != null) {
                        vista.mostrarMensaje("Producto actual:");
                        vista.mostrarProducto(existente);
                        ProductoOtaku actualizado = vista.pedirDatosProducto(true);
                        actualizado.setId(id);
                        dao.actualizarProducto(actualizado);
                    } else {
                        vista.mostrarMensaje("Producto no encontrado.");
                    }
                }
                case 7 -> {
                    int id = vista.pedirId();
                    boolean eliminado = dao.eliminarProducto(id);
                    vista.mostrarMensaje(eliminado ? "Producto eliminado." : "No se pudo eliminar.");
                }
                case 8 -> {
                    vista.mostrarMensaje("Gracias por usar Akihabara Market.");
                    salir = true;
                    vista.cerrarScanner();
                    dao.cerrar(); // Cierra la conexión
                }
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        }
    }
}

