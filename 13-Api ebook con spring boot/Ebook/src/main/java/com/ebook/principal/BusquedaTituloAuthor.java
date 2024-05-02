package com.ebook.principal;

import com.ebook.modelo.DatosDeAuthor;
import com.ebook.modelo.DatosLibros;
import com.ebook.modelo.LibroResults;

public class BusquedaTituloAuthor implements IPrincipal{
    public void busquedaTituloAuthor() {
        //buscar libro por titulo o autor
        System.out.println("Buscar por titulo o author: ");
        String buscar_author_titulo = scanner.nextLine();
        var json = consultaApi.obtenerDatosDeLaApi(url + author_title + buscar_author_titulo.replace(" ", "+" ) );
        DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
        if(datos != null){
            LibroResults libroResults = datos.results().get(0);
            System.out.println("------------------------------------------------------");
            System.out.println("                  TITULO - AUTOR                      ");
            System.out.printf("%s%n", buscar_author_titulo.toUpperCase());
            System.out.println("------------------------------------------------------");
            System.out.println("Id: " + libroResults.id());
            System.out.println("Titulo: " + libroResults.titulo());
            for (DatosDeAuthor autor : libroResults.authors()) {
                System.out.println("Autor(s): " + autor.name());
                System.out.println("Año nacimiento: " + autor.birth_year());
                System.out.println("Año muerte: " + autor.death_year());
            }
            System.out.println("Lenguajes: " + libroResults.languages());
            System.out.println("Subject: " + libroResults.subjects());
            System.out.println("Bookshelves: " + libroResults.bookshelves());
            System.out.println("Copyright: " + libroResults.copyright());
            System.out.println("Media type: " + libroResults.media_type());
            System.out.println("Download count: " + libroResults.download_count());
            System.out.println("------------------------------------------------------");
        }
    }

}
