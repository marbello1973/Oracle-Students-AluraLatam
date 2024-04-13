package com.starwars.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.starwars.http.HttpPeticion;
import com.starwars.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<TituloOmdb> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while(true) {

            System.out.println("Ingrese un numero entre 1 y 6, o cero(0) para salir");
            var busqueda = scanner.nextInt();
            if(busqueda == 0){
                break;
            }

            HttpPeticion http = new HttpPeticion();
            String json = http.httpClient(busqueda);

            TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.printf("%s adicionado.\n", tituloOmdb.title());
            titulos.add(tituloOmdb);
        }
        /*System.out.println("Titulos: " + titulos);*/
        FileWriter savedWriter = new FileWriter("StarWars.json");
            savedWriter.write(gson.toJson(titulos));
            savedWriter.close();
    }
}
