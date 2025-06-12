package com.akihabara.market.dao;

import com.akihabara.market.model.ProductoOtaku;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private DatabaseConnection db;
    private Connection conexion;

    public ProductoDAO() {
        db = new DatabaseConnection();
        conexion = db.getConexion(); 
    }
    // 1. Agregar un producto
    public void agregarProducto(ProductoOtaku producto) {
        String sql = "INSERT INTO producto (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.executeUpdate();
            System.out.println("Producto agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

    // 2. Obtener un producto por su ID
    public ProductoOtaku obtenerProductoPorId(int id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductoOtaku(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener producto: " + e.getMessage());
        }
        return null;
    }

    // 3. Obtener todos los productos
    public List<ProductoOtaku> obtenerTodosLosProductos() {
        List<ProductoOtaku> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ProductoOtaku producto = new ProductoOtaku(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }
        return lista;
    }

    // 4. Actualizar un producto
    public boolean actualizarProducto(ProductoOtaku producto) {
        String sql = "UPDATE producto SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.setInt(5, producto.getId());
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    // 5. Eliminar un producto por ID
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    // 6. Buscar productos por nombre (parcial)
    public List<ProductoOtaku> buscarProductosPorNombre(String nombre) {
        List<ProductoOtaku> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + nombre + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProductoOtaku producto = new ProductoOtaku(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                    );
                    lista.add(producto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos por nombre: " + e.getMessage());
        }
        return lista;
    }

    // 7. Buscar productos por categoría (exacta)
    public List<ProductoOtaku> buscarProductoPorCategoria(String categoria) {
        List<ProductoOtaku> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE categoria = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, categoria);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProductoOtaku producto = new ProductoOtaku(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                    );
                    lista.add(producto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos por categoría: " + e.getMessage());
        }
        return lista;
    }

    public void cerrar() {
        db.cerrarConexion();
    }
}
