package misPaquetes;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionEmpleados {

    static final String ARCHIVO = "empleados.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        anadirEmpleado(scanner);
                        break;
                    case 2:
                        mostrarEmpleados();
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // limpiar entrada incorrecta
                opcion = 0;
            }

        } while (opcion != 3);

        scanner.close();
    }

    // Método para añadir un empleado
    public static void anadirEmpleado(Scanner scanner) {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();

            System.out.print("Salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // limpiar buffer

            Empleado nuevo = new Empleado(nombre, edad, salario);

            ArrayList<Empleado> lista = cargarEmpleados(); // esta línea va aquí
            lista.add(nuevo);
            guardarEmpleados(lista);

            System.out.println("Empleado añadido correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Datos no válidos. Asegúrate de introducir edad y salario correctamente.");
            scanner.nextLine(); // limpiar entrada
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar o cargar empleados: " + e.getMessage());
        }
    }


    // Método para mostrar empleados
    public static void mostrarEmpleados() {
        try {
            ArrayList<Empleado> lista = cargarEmpleados();
            if (lista.isEmpty()) {
                System.out.println("No hay empleados registrados.");
            } else {
                System.out.println("\n--- Lista de empleados ---");
                for (Empleado emp : lista) {
                    System.out.println(emp);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los empleados: " + e.getMessage());
        }
    }

    // Cargar empleados desde el archivo
    public static ArrayList<Empleado> cargarEmpleados() throws IOException, ClassNotFoundException {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return new ArrayList<>();

        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) entrada.readObject();
        entrada.close();
        return empleados;
    }

    // Guardar empleados en el archivo
    public static void guardarEmpleados(ArrayList<Empleado> lista) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
        salida.writeObject(lista);
        salida.close();
    }
}
