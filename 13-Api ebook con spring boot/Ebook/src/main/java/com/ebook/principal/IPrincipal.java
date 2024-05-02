package com.ebook.principal;

import com.ebook.convertirdatos.ConvertirDatos;
import com.ebook.modelo.LibroResults;
import com.ebook.servicio.ConsultaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IPrincipal {
    String url = "https://gutendex.com/books/";
    String author_title = "?search=";
    Scanner scanner = new Scanner(System.in);
    ConsultaApi consultaApi = new ConsultaApi();
    ConvertirDatos conversor = new ConvertirDatos();
    List<LibroResults> libroResults = new ArrayList<>();
}
