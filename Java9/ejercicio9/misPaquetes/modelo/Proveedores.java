package misPaquetes.modelo;

import java.sql.*;
import java.util.Scanner;

public class Proveedores {
    private final Scanner entrada = new Scanner(System.in);

    public void crearProveedor() {
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("CIF: ");
        String cif = entrada.nextLine();
        System.out.print("Teléfono: ");
        String telefono = entrada.nextLine();

        String sql = "INSERT INTO Proveedores (nombre, cif, telefono) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, cif);
            stmt.setString(3, telefono);
            stmt.executeUpdate();
            System.out.println("Proveedor creado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProveedor() {
        String sql = "SELECT * FROM Proveedores";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s | CIF: %s | Teléfono: %s\n",
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("cif"),
                        rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProveedor() {
        System.out.print("ID del proveedor a modificar: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Nuevo CIF: ");
        String cif = entrada.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = entrada.nextLine();

        String sql = "UPDATE Proveedores SET nombre = ?, cif = ?, telefono = ? WHERE id_proveedor = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, cif);
            stmt.setString(3, telefono);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Proveedor actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor() {
        System.out.print("ID del proveedor a eliminar: ");
        int id = entrada.nextInt();

        String sql = "DELETE FROM Proveedores WHERE id_proveedor = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Proveedor eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
