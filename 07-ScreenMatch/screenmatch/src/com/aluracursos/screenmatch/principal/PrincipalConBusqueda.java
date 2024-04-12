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
import java.util.Scanner;

public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba nombre de pelicula");
        var busqueda = sc.nextLine();

        String busquedaCodificada = URLEncoder.encode(busqueda, "UTF-8");

        String url = "https://www.omdbapi.com/?t="+busquedaCodificada+"&apikey=c998aa21";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println("Mi titulo omdb: " + miTituloOmdb);

            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println(miTitulo);

            FileWriter escritura = new FileWriter("peliculas.txt");
            escritura.write(miTitulo.toString());
            escritura.close();

        }catch(NumberFormatException ex) {
            System.out.println("Error al ejecutar app");
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println("Error del programa");
        }finally {
            System.out.println("Finalizo ejecucion...!");
        }


    }
}
