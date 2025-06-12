import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


import com.google.gson.*;


public class Main {


    public static void main(String[] args) {
        String apiKey = "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"; // Sustituye esto por tu clave


        HttpClient client = HttpClient.newHttpClient();
        Scanner scanner = new Scanner(System.in);


        // Historial de conversación
        JsonArray messages = new JsonArray();


        System.out.println("Escribe tu mensaje (escribe 'FIN' para salir):");


        while (true) {
            System.out.print("Tú: ");
            String userInput = scanner.nextLine();


            if (userInput.equalsIgnoreCase("FIN")) {
                System.out.println("Conversación finalizada.");
                break;
            }


            // Añadir mensaje del usuario al historial
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", userInput);
            messages.add(userMessage);


            try {
                // Crear el cuerpo del request
                JsonObject body = new JsonObject();
                body.addProperty("model", "mistralai/mistral-7b-instruct:free");
                body.add("messages", messages);


                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("https://openrouter.ai/api/v1/chat/completions"))
                        .header("Authorization", "Bearer " + apiKey)
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                        .build();


                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                String respuesta = json
                        .getAsJsonArray("choices")
                        .get(0)
                        .getAsJsonObject()
                        .getAsJsonObject("message")
                        .get("content")
                        .getAsString();


                // Mostrar respuesta y añadirla al historial
                System.out.println("LLM: " + respuesta);


                JsonObject assistantMessage = new JsonObject();
                assistantMessage.addProperty("role", "assistant");
                assistantMessage.addProperty("content", respuesta);
                messages.add(assistantMessage);


            } catch (Exception e) {
                System.out.println("Error al comunicar con OpenRouter: " + e.getMessage());
            }
        }


        scanner.close();
    }
}
