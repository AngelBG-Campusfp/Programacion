package misPaquetes;

//Importamos los paquetes necesarios
import java.util.Scanner;
import java.util.HashMap;

//Creamos clase Main
public class Main {

    //Almacenar los animales con hash map
    private static HashMap<Integer, Animal> animales = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menu principal
        while (true) {
            System.out.println("1. Registrar un animal");
            System.out.println("2. Buscar animal por chip");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                registrarAnimal(scanner);
            } else if (opcion == 2) {
                buscarPorChip(scanner);
            } else if (opcion == 3) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    //Registrar un animal
    public static void registrarAnimal(Scanner scanner) {
        scanner.nextLine(); //Para que el codigo se vea mas limpio
        System.out.print("Número de chip: ");
        int chip = scanner.nextInt();

        if (animales.containsKey(chip)) {
            System.out.println("Ese número de chip ya está registrado.");
        } else {
            scanner.nextLine(); //Para que el codigo se vea mas limpio

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); //Para que el codigo se vea mas limpio

            System.out.print("Raza: ");
            String raza = scanner.nextLine();

            System.out.print("¿Está adoptado? (true/false): ");
            boolean adoptado = scanner.nextBoolean();

            System.out.print("¿Es perro? (true para perro, false para gato): ");
            boolean esPerro = scanner.nextBoolean();

            if (esPerro) {
                System.out.print("¿Es grande? (true/false): ");
                boolean tamaño = scanner.nextBoolean();
                Perro perro = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
                animales.put(chip, perro);  //Guardamos el animal
                System.out.println("");
            } else {
                System.out.print("¿Test leucemia positivo? (true/false): ");
                boolean leucemia = scanner.nextBoolean();
                Gato gato = new Gato(chip, nombre, edad, raza, adoptado, leucemia);
                animales.put(chip, gato);  //Guardamos el animal 
                System.out.println("");
            }
        }
    }

    //Buscar un Animal por su numero de chip
    public static void buscarPorChip(Scanner scanner) {
        System.out.print("Introduce el número de chip a buscar: ");
        int chip = scanner.nextInt();

        if (animales.containsKey(chip)) {
            Animal animal = animales.get(chip);
            animal.mostrar();
            System.out.println("");
        } else {
            System.out.println("No se encontró ningún animal con ese número de chip.");
        }
    }
}
