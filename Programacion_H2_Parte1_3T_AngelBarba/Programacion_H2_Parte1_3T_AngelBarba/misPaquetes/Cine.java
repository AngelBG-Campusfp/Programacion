package misPaquetes;

import java.sql.*;
import java.util.Scanner;

public class Cine {

    public static void main(String[] args) {
        // ponemos los datos par conectarnos a la base de datos
        String url = "jdbc:mysql://localhost:3306/cine_angelbarba";
        String usuario = "root"; 
        String contraseña = "curso";

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 2) {
            // menu
            System.out.println("\n=== MENÚ CINE ===");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    try {
                        // establecemos la conecion con la base de datos
                        Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

                        String sql = "SELECT p.id_pelicula, p.titulo, p.duracion, p.ano, g.genero " +
                                		"FROM Pelicula p JOIN Genero g ON p.id = g.id";

                        Statement stmt = conexion.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

                        // mostrar resultados
                        System.out.println("\n--- Lista de Películas ---");
                        while (rs.next()) {
                        	// %s para cadena de texto formateada y %d para cadena de numeros
                            System.out.printf("ID: %s\n", rs.getString("id_pelicula"));
                            System.out.printf("Título: %s\n", rs.getString("titulo"));
                            System.out.printf("Duración: %d minutos\n", rs.getInt("duracion"));
                            System.out.printf("Año: %d\n", rs.getInt("ano"));
                            System.out.printf("Género: %s\n", rs.getString("genero"));
                            System.out.println("------------------------------");
                        }

                        // Cerrar conexión
                        rs.close();
                        stmt.close();
                        conexion.close();

                    } catch (SQLException e) {
                        System.out.println("❌ Error al conectar o consultar: " + e.getMessage());
                    }

                } else if (opcion == 2) {
                    System.out.println("Hasta luego.");
                } else {
                    System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número.");
            }
        }

        scanner.close();
    }
}


