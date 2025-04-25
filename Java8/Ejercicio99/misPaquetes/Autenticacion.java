package misPaquetes;

import java.io.*;
import java.util.*;

public class Autenticacion {

    static final String ARCHIVO = "usuarios.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Autenticación ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrar(scanner);
                        break;
                    case 2:
                        iniciarSesion(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                opcion = 0;
            }

        } while (opcion != 3);

        scanner.close();
    }

    // Registro de usuario
    public static void registrar(Scanner scanner) {
        try {
            System.out.print("Nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();

            if (usuario.isBlank() || contraseña.isBlank()) {
                System.out.println("Usuario y contraseña no pueden estar vacíos.");
                return;
            }

            if (usuarioExiste(usuario)) {
                System.out.println("Este usuario ya existe.");
                return;
            }

            FileWriter fw = new FileWriter(ARCHIVO, true);
            fw.write(usuario + ":" + contraseña + "\n");
            fw.close();

            System.out.println("Usuario registrado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    // Verifica si el usuario ya está registrado
    public static boolean usuarioExiste(String usuario) throws IOException {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return false;

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.split(":")[0].equals(usuario)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    // Inicio de sesión
    public static void iniciarSesion(Scanner scanner) {
        try {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();

            if (credencialesValidas(usuario, contraseña)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario + "!");
            } else {
                System.out.println("Credenciales incorrectas.");
            }

        } catch (IOException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
        }
    }

    // Verifica si usuario y contraseña coinciden
    public static boolean credencialesValidas(String usuario, String contraseña) throws IOException {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return false;

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(contraseña)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
}
