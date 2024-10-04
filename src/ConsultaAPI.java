import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public Conversor consultaPrecio() {

        // URL de la API con el link para obtener los datos de cambio de USD
        URI link = URI.create("https://v6.exchangerate-api.com/v6/f80eb076a656137453f34386/latest/USD");

        // Creación del cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();

        HttpResponse<String> response = null;
        try {
            // Envío de la solicitud HTTP
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Parseo del JSON a un objeto Conversor utilizando Gson
        return new Gson().fromJson(response.body(), Conversor.class);
    }
}
