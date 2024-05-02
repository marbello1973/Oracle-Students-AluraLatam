package com.ebook.principal;

import com.ebook.convertirdatos.ConvertirDatos;
import com.ebook.modelo.LibroResults;
import com.ebook.servicio.ConsultaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IPrincipal {
    String url = "https://gutendex.com/books/";
    String author_title = "?search="; // buscar libros por autor o titulo
    String topic = "?topic="; //buscar libros por una fase especifica
    /*
    Encontrar libros con al menos un autor vivo en un rango determinado de años ejemplo: ?author_year_end=-499
    se puede combinar ejemplo: author_year_start=1800&author_year_end=1899
    */
    String author_year_end = "author_year_end=";
    String author_year_start = "author_year_start=";
    String copyright = "?copyright="; //Estado de derechos de autor true o false

    Scanner scanner = new Scanner(System.in);
    ConsultaApi consultaApi = new ConsultaApi();
    ConvertirDatos conversor = new ConvertirDatos();
    List<LibroResults> libroResults = new ArrayList<>();
}
