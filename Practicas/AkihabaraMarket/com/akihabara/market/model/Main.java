package com.akihabara.market.model;

import com.akihabara.market.dao.*;

public class Main {
    public static void main(String[] args) {
        // NUevo objeto otaku
        ProductoOtaku producto = new ProductoOtaku(1, "Figura Naruto", "Figura", 29.99, 15);
        System.out.println(producto.toString());

        // Probar la conexión a la base de datos
        DatabaseConnection dbConn = new DatabaseConnection();

        if (dbConn.getConexion() != null) {
            System.out.println("🎉 Conexión verificada desde Main.java");
        } else {
            System.out.println("⚠️ La conexión no está disponible.");
        }

        dbConn.cerrarConexion();
    }
}
