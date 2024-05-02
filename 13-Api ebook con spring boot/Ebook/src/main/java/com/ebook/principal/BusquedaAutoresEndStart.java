package com.ebook.principal;

import com.ebook.modelo.DatosLibros;
import com.ebook.modelo.LibroResults;
import java.util.InputMismatchException;
import java.util.List;

public class BusquedaAutoresEndStart implements IPrincipal {
    public void busquedaRangoAutores(){
        System.out.println("Ingrese los rangos entre años Inicio/Fin");
        try{
            System.out.print("Año inicio: ");
            int starYear = scanner.nextInt();
            System.out.print("Año fin: ");
            int endYear = scanner.nextInt();
            var json = consultaApi.obtenerDatosDeLaApi(url + "?"+ author_year_start + starYear + "&" + author_year_end + endYear );
            var datos = conversor.obtenerDatos(json, DatosLibros.class);
            List<LibroResults> libroResultsAños = datos.results();
            System.out.println("------------------------------------------------------");
            System.out.println("                  FECHA AUTORES                       ");
            System.out.printf ("Start: %d End: %d%n", starYear, endYear               );
            System.out.println("------------------------------------------------------");
            //libroResultsAños.forEach(e -> System.out.println(e.authors()));
            libroResultsAños.forEach(e -> e.authors()
                    .forEach(d -> System.out.println(
                            "Nombre: " + d.name() + " --- " +
                                    "Fecha Nacimiento: " + d.birth_year() + " --- " +
                                    "Fecha Muerte: " + d.death_year())));
            System.out.println("------------------------------------------------------");
        }catch(InputMismatchException ex){
            System.out.println("Error: " + ex.getMessage() + " Solo numero positivos o negativos");;
        }
    }
}
