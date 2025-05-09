package misPaquetes.controlador;

import misPaquetes.modelo.Articulos;
import misPaquetes.modelo.Cliente;
import misPaquetes.modelo.Proveedores;
import misPaquetes.modelo.Facturas;
import misPaquetes.modelo.Ventas;
import misPaquetes.modelo.InformeVentas;

import java.util.Scanner;

public class Controlador {
    private final Scanner entrada = new Scanner(System.in);
    private final Cliente clientes = new Cliente();
    private final Proveedores proveedores = new Proveedores();
    private final Articulos articulos = new Articulos();
    private final Facturas facturas = new Facturas();
    private final Ventas ventas = new Ventas();
    private final InformeVentas informeVentas = new InformeVentas(); 

    public void gestionarClientes() {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Clientes --");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Listar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> clientes.crearCliente();
                case 2 -> clientes.listarCliente();
                case 3 -> clientes.actualizarCliente();
                case 4 -> clientes.eliminarCliente();
            }
        } while (opcion != 0);
    }

    public void gestionarProveedores() {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Proveedores --");
            System.out.println("1. Crear Proveedor");
            System.out.println("2. Listar Proveedor");
            System.out.println("3. Actualizar Proveedor");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> proveedores.crearProveedor();
                case 2 -> proveedores.listarProveedor();
                case 3 -> proveedores.actualizarProveedor();
                case 4 -> proveedores.eliminarProveedor();
            }
        } while (opcion != 0);
    }

    public void gestionarArticulos() {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Artículos --");
            System.out.println("1. Crear Articulo");
            System.out.println("2. Listar Articulo");
            System.out.println("3. Actualizar Articulo");
            System.out.println("4. Eliminar Articulo");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> articulos.crearArticulo();
                case 2 -> articulos.listarArticulo();
                case 3 -> articulos.actualizarArticulo();
                case 4 -> articulos.eliminarArticulo();
            }
        } while (opcion != 0);
    }

    public void gestionarFacturas() {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Facturas Recibidas --");
            System.out.println("1. Crear Factura");
            System.out.println("2. Listar Facturas");
            System.out.println("3. Actualizar Factura");
            System.out.println("4. Eliminar Factura");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> facturas.crearFactura();
                case 2 -> facturas.listarFactura();
                case 3 -> facturas.actualizarFactura();
                case 4 -> facturas.eliminarFactura();
            }
        } while (opcion != 0);
    }

    public void gestionarVentas() {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Ventas --");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Listar Ventas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> ventas.crearVenta();
                case 2 -> ventas.listarVenta();
            }
        } while (opcion != 0);
    }

    public void generarInformeVentas() {
        System.out.println("\n-- Informe de Ventas por Cliente --");
        informeVentas.generarInforme();
    }
}

