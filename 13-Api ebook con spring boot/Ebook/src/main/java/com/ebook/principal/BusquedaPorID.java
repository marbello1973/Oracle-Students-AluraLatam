package com.ebook.principal;

import com.ebook.modelo.DatosDeAuthor;
import com.ebook.modelo.LibroResults;

public class BusquedaPorID implements IPrincipal{
    public void busquedaID(){
        //buscar libro por id
        System.out.println("Buscar libros por id: ");
        try{
            Long buscar_por_id = scanner.nextLong();
            if(buscar_por_id <= 0) System.out.println("Ingrese numero mayor a 0 (cero)");

            var json = consultaApi.obtenerDatosDeLaApi("https://gutendex.com/books/" + buscar_por_id + "/");

            //validar que la url tenga data
            if(json.isEmpty()){
                System.out.println("No hay datos");
                return;
            }

            //deserializar los datos
            var datosID = conversor.obtenerDatos(json, LibroResults.class);
            if(datosID != null){
                LibroResults libroResults = datosID;
                System.out.println("Libro encontrado");
                System.out.println("ID: " + libroResults.id());
                System.out.println("Titulo: " + libroResults.titulo());
                for (DatosDeAuthor autor : libroResults.authors()) {
                    System.out.println("Autor(s): " + autor.name());
                    System.out.println("Año nacimiento: " + autor.birth_year());
                    System.out.println("Año muerte: " + autor.death_year());
                }
                System.out.println("Lenguaje: " + libroResults.languages());
                System.out.println("Temas: " + libroResults.subjects());
                System.out.println("Medio: " + libroResults.media_type());
                System.out.println("Descargas: " + libroResults.download_count());

                System.out.println();
            }else {
                System.out.println("Id no existe");
            }
        }catch (NullPointerException ex){
            throw new RuntimeException("ID negativo:");
        }
    }
}
