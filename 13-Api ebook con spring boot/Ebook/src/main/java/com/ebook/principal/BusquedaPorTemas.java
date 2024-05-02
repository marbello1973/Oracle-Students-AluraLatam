package com.ebook.principal;

import com.ebook.modelo.DatosDeAuthor;
import com.ebook.modelo.DatosLibros;
import com.ebook.modelo.LibroResults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPorTemas implements IPrincipal{
    public void busquedaLibrosPorTemas(){    System.out.println("Ingrese la frase o palabra");
        try{
            String tema = scanner.nextLine().toUpperCase();
            var json = consultaApi.obtenerDatosDeLaApi(url + topic + tema.replace(" ", "+" ) );
            DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
            if(datos != null){
                LibroResults libroResults = datos.results().get(0);
                System.out.println("------------------------------------------------------");
                System.out.println("                  TITULO - TEMAS                      ");
                System.out.printf("%s%n", tema.toUpperCase());
                System.out.println("------------------------------------------------------");
                System.out.println("Titulo: " + libroResults.titulo());
                System.out.println("Subject: " + libroResults.subjects());
                System.out.println("------------------------------------------------------");
            }
        }catch(IndexOutOfBoundsException ex){
            throw new RuntimeException("frase invalida");
        }
    }
}
