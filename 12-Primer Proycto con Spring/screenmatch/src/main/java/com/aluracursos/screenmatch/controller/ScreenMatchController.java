package com.aluracursos.screenmatch.controller;


import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.DoubleSummaryStatistics;


@Controller
public class ScreenMatchController {
    @Autowired
    private Principal principal;

    @GetMapping("/screen")
    public String mostrarEnIndexHTML(Model model){
        String mensaje = "!Hola desde Spring Boot";
        model.addAttribute("mensaje: ", mensaje);

        DoubleSummaryStatistics std = principal.calcularEstadisticas();
        model.addAttribute("std", std);
        return "index";
    }






}
