package misPaquetes;

//Importamos los paquetes necesarios
import java.util.Scanner;
import java.util.HashMap;

//Creamos clase Main
public class Main {

    //Almacenamos los animales
    private static HashMap<Integer, Animal> animales = new HashMap<>();
    
    //Almacenamos las adopciones
    private static HashMap<Integer, Adopcion> adopciones = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menu principal
        while (true) {
            System.out.println("1. Dar de alta animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal");
            System.out.println("4. Realizar adopción");
            System.out.println("5. Dar de baja");
            System.out.println("6. Mostrar estadísticas de gatos");
            System.out.println("7. Salir");
            
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                registrarAnimal(scanner);
            } else if (opcion == 2) {
                listarAnimales();
            } else if (opcion == 3) {
                buscarPorChip(scanner);
            } else if (opcion == 4) {
                realizarAdopcion(scanner);
            } else if (opcion == 5) {
                darDeBaja(scanner);
            } else if (opcion == 6) {
                mostrarEstadisticasGatos();
            } else if (opcion == 7) {
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
        scanner.nextLine(); //Para que el codigo se vea mas limpio limpia el scanner
        System.out.print("Número de chip: ");
        int chip = scanner.nextInt();

        if (animales.containsKey(chip)) {
            System.out.println("Ese número de chip ya está registrado.");
        } else {
            scanner.nextLine(); //Para que el codigo se vea mas limpio limpia el scanner

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); //Para que el codigo se vea mas limpio limpia el scanner

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

    //Listar todos los animales
    public static void listarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal animal : animales.values()) {
                animal.mostrar();
                System.out.println("");
            }
        }
    }

    //Buscar un Animal por su número de chip
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

    //Realizar una adopción si el animal existe y no está adoptado
    public static void realizarAdopcion(Scanner scanner) {
        System.out.print("Introduce el número de chip del animal a adoptar: ");
        int chip = scanner.nextInt();

        if (!animales.containsKey(chip)) {
            System.out.println("No existe un animal con ese chip.");
        } else {
            Animal animal = animales.get(chip);

            if (animal.isAdoptado()) {
                System.out.println("El animal ya está adoptado.");
            } else {
                scanner.nextLine(); //Para que el codigo se vea mas limpio limpia el scanner

                System.out.print("Nombre del adoptante: ");
                String nombreAdoptante = scanner.nextLine();

                System.out.print("DNI del adoptante: ");
                String dniAdoptante = scanner.nextLine();

                animal.setAdoptado(true); //Marcar como adoptado
                Adopcion adopcion = new Adopcion(animal.nombre, nombreAdoptante, dniAdoptante);
                adopciones.put(chip, adopcion); //Guardar la adopción

                System.out.println("¡Adopción realizada con éxito!");
            }
        }
    }

    //Dar de baja un animal y su adopcion
    public static void darDeBaja(Scanner scanner) {
        System.out.print("Introduce el número de chip del animal a dar de baja: ");
        int chip = scanner.nextInt();

        if (animales.containsKey(chip)) {
            animales.remove(chip); //Eliminar animal
            adopciones.remove(chip); //Eliminar adopción si existe
            System.out.println("Animal dado de baja correctamente.");
        } else {
            System.out.println("No se encontró ningún animal con ese chip.");
        }
    }

    //Mostrar estadísticas de gatos
    public static void mostrarEstadisticasGatos() {
        int totalGatos = 0;
        int gatosLeucemia = 0;

        for (Animal a : animales.values()) {
            if (a instanceof Gato) {
                totalGatos++;
                if (((Gato) a).isLeucemia()) {
                    gatosLeucemia++;
                }
            }
        }

        System.out.println("Total de gatos: " + totalGatos);
        System.out.println("Gatos con test de leucemia positivo: " + gatosLeucemia);
    }
}
