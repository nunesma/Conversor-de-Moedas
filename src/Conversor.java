import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private static String apiKey = "4e704559f064d64c66d1071f";
    private static String endereco = "https://v6.exchangerate-api.com/v6/";

    public static double consultar(String de, String para) {
        try {
            String link = endereco + apiKey + "/latest/" + de;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            JsonObject taxasDeConversao = json.getAsJsonObject("conversion_rates");

            if (taxasDeConversao.has(para)) {
                return taxasDeConversao.get(para).getAsDouble();
            } else {
                System.out.println("Moeda não encontrada");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }

}
