package com.gutenbergebook.controller;

import com.gutenbergebook.modelo.DatosGutendex;
import com.gutenbergebook.service.ConsultaApi;
import com.gutenbergebook.service.ConvertidorDeDatos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibroController {
/*
    @GetMapping("/libro")
    public String mostrarLibros(Model model){
        var consultaApi = new ConsultaApi();
        var json = consultaApi.obtenerDatosApi("https://gutendex.com/books/");
        ConvertidorDeDatos conversor = new ConvertidorDeDatos();
        var datos = conversor.obtenerDatosApi(json, DatosGutendex.class);
        model.addAttribute("datos", datos);
        return "index";
    }*/

}
