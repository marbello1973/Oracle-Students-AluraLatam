package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {

            System.out.println("Escriba nombre de pelicula");
            var busqueda = sc.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String busquedaCodificada = URLEncoder.encode(busqueda, "UTF-8");

            String url = "https://www.omdbapi.com/?t=" + busquedaCodificada + "&apikey=c998aa21";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                System.out.println(json);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println("Mi titulo omdb: " + miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println(miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException ex) {
                System.out.println("Error al ejecutar app");
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error del programa");
            } finally {
                System.out.println("Finalizo ejecucion...!");
            }

        }
        System.out.println(titulos);
        FileWriter escritura = new FileWriter("peliculas.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

    }
}
