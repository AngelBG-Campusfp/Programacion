package misPaquetes.modelo;

import java.sql.*;
import java.util.Scanner;

public class Articulos {
    private final Scanner entrada = new Scanner(System.in);

    public void crearArticulo() {
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Precio unitario: ");
        double precio = entrada.nextDouble();
        System.out.print("Stock: ");
        int stock = entrada.nextInt();

        String sql = "INSERT INTO Articulos (nombre, precio_unitario, stock) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, stock);
            stmt.executeUpdate();
            System.out.println("Artículo creado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarArticulo() {
        String sql = "SELECT * FROM Articulos";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s | Precio: %.2f | Stock: %d\n",
                        rs.getInt("id_articulo"),
                        rs.getString("nombre"),
                        rs.getDouble("precio_unitario"),
                        rs.getInt("stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = entrada.nextDouble();
        System.out.print("Nuevo stock: ");
        int stock = entrada.nextInt();

        String sql = "UPDATE Articulos SET nombre = ?, precio_unitario = ?, stock = ? WHERE id_articulo = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, stock);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Artículo actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int id = entrada.nextInt();

        String sql = "DELETE FROM Articulos WHERE id_articulo = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Artículo eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
