package misPaquetes;

import java.io.*;

// Clase Producto
class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio + ", Categoría: " + categoria;
    }
}

