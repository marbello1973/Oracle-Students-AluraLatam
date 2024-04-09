package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.caculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.caculos.FiltroRecomendacion;

//herencia, polimorfismo, encapsulamiento

public class Principal {

    public static void main(String[] args) {


        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getSumaDelasEvaluaciones());
        System.out.println(miPelicula.calcularMedia());

        Serie casaDragon = new Serie();
        casaDragon.setNombre("Casa del Dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporadas(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPeli = new Pelicula();
        otraPeli.setNombre("Matrix");
        otraPeli.setFechaDeLanzamiento(1997);
        otraPeli.setDuracionEnMinutos(180);
        otraPeli.setIncluidoEnPlan(true);

        CalculadoraDeTiempo calculadoraDeTiempo = new CalculadoraDeTiempo();
        calculadoraDeTiempo.incluye(miPelicula);
        calculadoraDeTiempo.incluye(casaDragon);
        calculadoraDeTiempo.incluye(otraPeli);
        System.out.println(calculadoraDeTiempo.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);
        filtroRecomendacion.filtra(otraPeli);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("la casa targaryan");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);




    }
}
