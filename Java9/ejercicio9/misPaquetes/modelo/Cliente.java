package misPaquetes.modelo;

import java.sql.*;
import java.util.Scanner;

public class Cliente {
    private final Scanner entrada = new Scanner(System.in);

    public void crearCliente() {
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();
        System.out.print("Teléfono: ");
        String telefono = entrada.nextLine();

        String sql = "INSERT INTO Clientes (nombre, email, telefono) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, telefono);
            stmt.executeUpdate();
            System.out.println("Cliente creado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarCliente() {
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Lista de Clientes ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s | Email: %s | Teléfono: %s\n",
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente() {
        System.out.print("ID del cliente a modificar: ");
        int id = entrada.nextInt();
        entrada.nextLine(); 

        System.out.print("Nuevo nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Nuevo email: ");
        String email = entrada.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = entrada.nextLine();

        String sql = "UPDATE Clientes SET nombre = ?, email = ?, telefono = ? WHERE id_cliente = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, telefono);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Cliente actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        int id = entrada.nextInt();

        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

