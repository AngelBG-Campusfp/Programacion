package misPaquetes;

import java.io.*;

public class SerializarAnimal {

    public static void main(String[] args) {
        // Crear objeto Animal
        Animal miAnimal = new Animal("Firulais", "Perro");

        // Serializar
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("animal.ser"));
            salida.writeObject(miAnimal);
            salida.close();
            System.out.println("Animal serializado correctamente en 'animal.ser'.\n");
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }

        // Deserializar
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("animal.ser"));
            Animal animalLeido = (Animal) entrada.readObject();
            entrada.close();

            System.out.println("Animal deserializado:");
            System.out.println("Nombre: " + animalLeido.getNombre());
            System.out.println("Especie: " + animalLeido.getEspecie());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }
}
