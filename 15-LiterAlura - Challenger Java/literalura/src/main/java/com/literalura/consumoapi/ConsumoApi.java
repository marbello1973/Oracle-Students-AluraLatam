package com.literalura.consumoapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obtenerDatosApi(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }




    /*public String obtenerDatosApi(String ulr){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ulr))
                .build();
        HttpResponse response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
        String json = String.valueOf(response.body());
        return json;
    }*/
}
