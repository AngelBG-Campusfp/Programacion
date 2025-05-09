package misPaquetes.modelo;

import java.sql.*;
import java.util.Scanner;

public class Ventas {
    private final Scanner entrada = new Scanner(System.in);

    public void crearVenta() {
        System.out.print("ID Cliente: ");
        int idCliente = entrada.nextInt();
        System.out.print("ID Artículo: ");
        int idArticulo = entrada.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = entrada.nextInt();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = entrada.next();

        String sql = "INSERT INTO Ventas (id_cliente, id_articulo, cantidad, fecha_venta) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idArticulo);
            stmt.setInt(3, cantidad);
            stmt.setString(4, fecha);
            stmt.executeUpdate();
            System.out.println("Venta registrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarVenta() {
        String sql = "SELECT * FROM Ventas";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | ID Cliente: %d | ID Artículo: %d | Cantidad: %d | Fecha: %s\n",
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_articulo"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha_venta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar() {
        System.out.print("ID de la venta a modificar: ");
        int id = entrada.nextInt();
        System.out.print("Nuevo ID Cliente: ");
        int idCliente = entrada.nextInt();
        System.out.print("Nuevo ID Artículo: ");
        int idArticulo = entrada.nextInt();
        System.out.print("Nueva Cantidad: ");
        int cantidad = entrada.nextInt();
        System.out.print("Nueva Fecha: ");
        String fecha = entrada.next();

        String sql = "UPDATE Ventas SET id_cliente = ?, id_articulo = ?, cantidad = ?, fecha_venta = ? WHERE id_venta = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idArticulo);
            stmt.setInt(3, cantidad);
            stmt.setString(4, fecha);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Venta actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar() {
        System.out.print("ID de la venta a eliminar: ");
        int id = entrada.nextInt();

        String sql = "DELETE FROM Ventas WHERE id_venta = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Venta eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
