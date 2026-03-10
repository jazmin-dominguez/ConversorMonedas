import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertidorApp {
    public double obtenerConversion(String monedaBase, String monedaObjetivo, double cantidad, String apiKey) {
        // Construimos la URL con el formato de Pair Conversion de la API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaBase + "/" + monedaObjetivo + "/" + cantidad);

        // Construyendo el Cliente (HttpClient)
        HttpClient client = HttpClient.newHttpClient();

        // Construyendo la Solicitud (HttpRequest)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Construyendo la Respuesta (HttpResponse)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Analizando la respuesta JSON con Gson
            RespuestaConversion respuesta = new Gson().fromJson(response.body(), RespuestaConversion.class);

            // Retornamos el valor ya convertido
            return respuesta.conversion_result();

        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
