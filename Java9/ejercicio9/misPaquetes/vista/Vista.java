package misPaquetes.vista;

import misPaquetes.controlador.Controlador;
import java.util.Scanner;

public class Vista {
    private final Scanner entrada = new Scanner(System.in);
    private final Controlador controlador = new Controlador();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Proveedores");
            System.out.println("3. Gestión de Artículos");
            System.out.println("4. Gestión de Facturas Recibidas");
            System.out.println("5. Gestión de Ventas");
            System.out.println("6. Informe de Ventas por Cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> controlador.gestionarClientes();
                case 2 -> controlador.gestionarProveedores();
                case 3 -> controlador.gestionarArticulos();
                case 4 -> controlador.gestionarFacturas();
                case 5 -> controlador.gestionarVentas();
                case 6 -> controlador.generarInformeVentas();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}


