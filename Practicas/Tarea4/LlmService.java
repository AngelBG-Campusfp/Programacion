import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import com.google.gson.*;

public class LlmService {

    private String apiKey;
    private final String endpoint = "https://openrouter.ai/api/v1/chat/completions";
    private final HttpClient client;

    public LlmService() throws IOException {
        this.apiKey = cargarApiKey();
        this.client = HttpClient.newHttpClient();
    }

    private String cargarApiKey() throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        }
        return props.getProperty("OPENROUTER_API_KEY");
    }

    public String sugerirNombreProducto(String tipo, String franquicia) {
        try {
            String prompt = String.format("Sugiere un nombre llamativo y original para un producto otaku del tipo '%s' basado en la franquicia '%s'.", tipo, franquicia);

            JsonArray messages = new JsonArray();
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", prompt);
            messages.add(userMessage);

            JsonObject body = new JsonObject();
            body.addProperty("model", "mistralai/mistral-7b-instruct:free");
            body.add("messages", messages);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(endpoint))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            return json
                    .getAsJsonArray("choices")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString()
                    .trim();

        } catch (Exception e) {
            System.out.println("Error al obtener nombre del LLM: " + e.getMessage());
            return "Nombre no disponible";
        }
    }
}
