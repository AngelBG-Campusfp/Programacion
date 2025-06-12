package com.akihabara.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Constantes para los datos de conexión
    private static final String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db";
    private static final String USER = "userAkihabara";
    private static final String PASSWORD = "curso"; 

    // Propiedad de conexión
    private Connection conexion;

    public DatabaseConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Se ha cargado en memoria el driver de MySQL.");

            // Establecer la conexión
            conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Se ha establecido con éxito la conexión a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Se ha cerrado la conexión con la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
