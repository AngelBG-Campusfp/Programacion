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

        // menu de opciones bucle while
        while (opcion != 5) {
            System.out.println("\n=== MENÚ 2CINE ===");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                // OPCION 1: mostrar todas las peliculas
                if (opcion == 1) {
                	// establecemos la conexion con la base de datos
                    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                        String sql = "SELECT p.id_pelicula, p.titulo, p.duracion, p.ano, g.genero " +
                                     "FROM Pelicula p JOIN Genero g ON p.id = g.id";
                        
                     // variables para las consultas SQL
                        Statement stmt = conexion.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

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

                     // cerramos las variables para las consultas SQL
                        rs.close();
                        stmt.close();
                    } catch (SQLException e) {
                        System.out.println("Error al consultar películas: " + e.getMessage());
                    }

                // OPCION 2: Añadir nueva pelicula
                } else if (opcion == 2) {
                	// establecemos la conexion con la base de datos
                    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                        System.out.print("ID Película: ");
                        String idPelicula = scanner.nextLine();

                        // Verificar si ya existe una película con ese ID
                        String consultaPelicula = "SELECT * FROM Pelicula WHERE id_pelicula = ?";
                        PreparedStatement probarStmt = conexion.prepareStatement(consultaPelicula);
                        probarStmt.setString(1, idPelicula);
                        ResultSet rs = probarStmt.executeQuery();

                        if (rs.next()) {
                            System.out.println("Ya existe una película con ese ID.");
                        } else {
                            // Solicitamos el resto de datos
                            System.out.print("Título: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Duración (minutos): ");
                            int duracion = Integer.parseInt(scanner.nextLine());
                            System.out.print("Año: ");
                            int ano = Integer.parseInt(scanner.nextLine());
                            System.out.print("ID Género ('Genero 1': Accion ; 'Genero 2': Comedia ; 'Genero 3': Drama): ");
                            String idGenero = scanner.nextLine();

                            // insertamos una pelicula
                            String insertarSQL = "INSERT INTO Pelicula (id_pelicula, titulo, duracion, ano, id) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement insertarStmt = conexion.prepareStatement(insertarSQL);
                            insertarStmt.setString(1, idPelicula);
                            insertarStmt.setString(2, titulo);
                            insertarStmt.setInt(3, duracion);
                            insertarStmt.setInt(4, ano);
                            insertarStmt.setString(5, idGenero);

                            int filas = insertarStmt.executeUpdate();
                            if (filas > 0) {
                                System.out.println("Película añadida correctamente.");
                            }
                        }

                        rs.close();
                        probarStmt.close();
                    } catch (SQLException e) {
                        System.out.println("Error al añadir película: " + e.getMessage());
                    }

                // OPCION 3: Eliminar pelicula
                } else if (opcion == 3) {
                	// establecemos la conexion con la base de datos
                    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                        System.out.print("Introduce el ID de la película a eliminar: ");
                        String idPelicula = scanner.nextLine();

                        // verificar la existencia
                        String selectSQL = "SELECT * FROM Pelicula WHERE id_pelicula = ?";
                        PreparedStatement selectStmt = conexion.prepareStatement(selectSQL);
                        selectStmt.setString(1, idPelicula);
                        ResultSet rs = selectStmt.executeQuery();

                        if (!rs.next()) {
                            System.out.println("La película no existe.");
                        } else {
                            // eliminar si existe
                            String borrarSQL = "DELETE FROM Pelicula WHERE id_pelicula = ?";
                            PreparedStatement borrarStmt = conexion.prepareStatement(borrarSQL);
                            borrarStmt.setString(1, idPelicula);
                            borrarStmt.executeUpdate();
                            System.out.println("Película eliminada correctamente.");
                            borrarStmt.close();
                        }

                        rs.close();
                        selectStmt.close();
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar película: " + e.getMessage());
                    }

                // OPCION 4: Modificar pelicula
                } else if (opcion == 4) {
                	// establecemos la conexion con la base de datos
                    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                        System.out.print("Introduce el ID de la película a modificar: ");
                        String idPelicula = scanner.nextLine();

                        // verificamos si existe
                        String selectSQL = "SELECT * FROM Pelicula WHERE id_pelicula = ?";
                        PreparedStatement selectStmt = conexion.prepareStatement(selectSQL);
                        selectStmt.setString(1, idPelicula);
                        ResultSet rs = selectStmt.executeQuery();

                        if (!rs.next()) {
                            System.out.println("La película no existe.");
                        } else {
                            // solicitamos nuevos valores de la pelicula
                            System.out.print("Nuevo título: ");
                            String nuevoTitulo = scanner.nextLine();
                            System.out.print("Nueva duración (minutos): ");
                            int nuevaDuracion = Integer.parseInt(scanner.nextLine());

                            // actualizamos en la base de datos
                            String updateSQL = "UPDATE Pelicula SET titulo = ?, duracion = ? WHERE id_pelicula = ?";
                            PreparedStatement actStmt = conexion.prepareStatement(updateSQL);
                            actStmt.setString(1, nuevoTitulo);
                            actStmt.setInt(2, nuevaDuracion);
                            actStmt.setString(3, idPelicula);
                            actStmt.executeUpdate();

                            System.out.println("Película actualizada correctamente.");
                            actStmt.close();
                        }

                        rs.close();
                        selectStmt.close();
                    } catch (SQLException e) {
                        System.out.println("Error al modificar película: " + e.getMessage());
                    }

                // OPCION 5: Salir
                } else if (opcion == 5) {
                    System.out.println("Hasta luego.");

                // opcion invalida
                } else {
                    System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número.");
            }
        }

        scanner.close();
    }
}


