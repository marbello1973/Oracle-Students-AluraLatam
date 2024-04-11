package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.caculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.caculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

//herencia, polimorfismo, encapsulamiento

public class Principal {

    public static void main(String[] args) {

        /*Pelicula miPelicula = new Pelicula("Encanto", 2023);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getSumaDelasEvaluaciones());
        System.out.println(miPelicula.calcularMedia());

        Pelicula otraPeli = new Pelicula("Matrix", 1997);
        otraPeli.setFechaDeLanzamiento(1997);
        otraPeli.setDuracionEnMinutos(180);
        otraPeli.setIncluidoEnPlan(true);*/

        Serie casaDragon = new Serie("Casa del Dragon", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporadas(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadoraDeTiempo = new CalculadoraDeTiempo();
        //calculadoraDeTiempo.incluye(miPelicula);
        calculadoraDeTiempo.incluye(casaDragon);
        //calculadoraDeTiempo.incluye(otraPeli);
        System.out.println(calculadoraDeTiempo.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        //filtroRecomendacion.filtra(miPelicula);
        //filtroRecomendacion.filtra(otraPeli);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("la casa targaryan");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);

        ArrayList<Serie> listaSerie = new ArrayList<>();
        listaSerie.add(casaDragon);
        listaSerie.forEach(System.out::println);

        var listaPeliculas = new ArrayList<>();
        //listaPeliculas.add(miPelicula);
        //listaPeliculas.add(otraPeli);
        listaPeliculas.forEach(System.out::println);

        if(listaPeliculas.size() < 2 ){
            System.out.println("excelente");
        }else{
            System.out.println("carrito lleno");
        }

        System.out.println(listaPeliculas.size());


    }
}
