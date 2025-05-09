package misPaquetes.modelo;

import java.sql.*;
import java.util.Scanner;

public class Facturas {
    private final Scanner entrada = new Scanner(System.in);

    public void crearFactura() {
        System.out.print("ID Proveedor: ");
        int idProveedor = entrada.nextInt();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = entrada.next();
        System.out.print("Total: ");
        double total = entrada.nextDouble();

        String sql = "INSERT INTO Facturas_Recibidas (id_proveedor, fecha, total) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProveedor);
            stmt.setString(2, fecha);
            stmt.setDouble(3, total);
            stmt.executeUpdate();
            System.out.println("Factura creada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarFactura() {
        String sql = "SELECT * FROM Facturas_Recibidas";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | ID Proveedor: %d | Fecha: %s | Total: %.2f\n",
                        rs.getInt("id_factura"),
                        rs.getInt("id_proveedor"),
                        rs.getString("fecha"),
                        rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarFactura() {
        System.out.print("ID de la factura a modificar: ");
        int id = entrada.nextInt();
        System.out.print("Nuevo ID Proveedor: ");
        int idProveedor = entrada.nextInt();
        System.out.print("Nueva Fecha: ");
        String fecha = entrada.next();
        System.out.print("Nuevo Total: ");
        double total = entrada.nextDouble();

        String sql = "UPDATE Facturas_Recibidas SET id_proveedor = ?, fecha = ?, total = ? WHERE id_factura = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProveedor);
            stmt.setString(2, fecha);
            stmt.setDouble(3, total);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Factura actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarFactura() {
        System.out.print("ID de la factura a eliminar: ");
        int id = entrada.nextInt();

        String sql = "DELETE FROM Facturas_Recibidas WHERE id_factura = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Factura eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

