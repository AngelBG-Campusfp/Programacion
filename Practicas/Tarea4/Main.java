import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            LlmService llm = new LlmService();

            System.out.println("Agregar nuevo producto otaku");
            System.out.print("Tipo de producto (ej: figura, camiseta): ");
            String tipo = scanner.nextLine();

            System.out.print("Franquicia (ej: Naruto, One Piece): ");
            String franquicia = scanner.nextLine();

            System.out.println("Generando nombre llamativo con IA...");
            String nombreSugerido = llm.sugerirNombreProducto(tipo, franquicia);

            System.out.println("Nombre sugerido: " + nombreSugerido);
            System.out.println("Producto guardado exitosamente.");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
