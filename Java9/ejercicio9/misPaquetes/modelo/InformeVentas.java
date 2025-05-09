package misPaquetes.modelo;

import java.sql.*;

public class InformeVentas {
    public void generarInforme() {
        String sql = "SELECT c.nombre, a.nombre AS articulo, v.cantidad, v.fecha_venta, " +
                "(v.cantidad * a.precio_unitario) AS total_gastado " +
                "FROM Ventas v " +
                "JOIN Clientes c ON v.id_cliente = c.id_cliente " +
                "JOIN Articulos a ON v.id_articulo = a.id_articulo " +
                "ORDER BY c.nombre, v.fecha_venta";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            String currentCliente = "";
            double totalGastado = 0;
            while (rs.next()) {
                String cliente = rs.getString("nombre");
                String articulo = rs.getString("articulo");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha_venta");
                double totalVenta = rs.getDouble("total_gastado");

                if (!cliente.equals(currentCliente)) {
                    if (!currentCliente.isEmpty()) {
                        System.out.println("Total gastado: " + totalGastado);
                    }
                    System.out.println("\nCliente: " + cliente);
                    currentCliente = cliente;
                    totalGastado = 0;
                }

                System.out.printf("Articulo: %s | Cantidad: %d | Fecha: %s | Total Venta: %.2f\n",
                        articulo, cantidad, fecha, totalVenta);
                totalGastado += totalVenta;
            }

            System.out.println("Total gastado: " + totalGastado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

