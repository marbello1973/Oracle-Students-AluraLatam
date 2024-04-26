package com.conversor.http;

import com.conversor.modelos.MonedasRecord;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPeticionApi {
    Dotenv dotenv = Dotenv.load();
    String URL_ENV = dotenv.get("URL_STR");
    public MonedasRecord realizarPeticionApi(String monedaOrigen) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENV + monedaOrigen))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            ex.getMessage();
        }
        if (response == null) {
            throw new RuntimeException("La respuesta del servidor es nula");
        }
        try{
            return new Gson().fromJson(response.body(), MonedasRecord.class);
        }catch(JsonSyntaxException ex){
            ex.getMessage();
        }
        return null;
    }
}
