package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.*;

import java.util.*;

public class PrincipalConLista {

    public static void main(String[] args) {

        //ArrayList<Titulo> lista = new ArrayList<>();
        Pelicula matrix = new Pelicula("Matrix", 1997);
        matrix.evalua(9);
        Pelicula aliens = new Pelicula("Aliens", 1994);
        aliens.evalua(6);
        Pelicula depredador = new Pelicula("Depredador", 1995);
        depredador.evalua(5);
        Serie lost = new Serie("Lost", 2000);
        lost.evalua(7);

        List<Titulo> lista = new LinkedList<>();

        lista.add(matrix);
        lista.add(aliens);
        lista.add(depredador);
        lista.add(lost);

        for (Titulo titulo : lista) {
            System.out.println(titulo.getNombre());
            if(titulo instanceof Pelicula pelicula){
                System.out.println(pelicula.getClasificacion());
            }
        }

        System.out.println("otra manera de iterar");
        lista.forEach(System.out::println);

        ArrayList<String> listaArtistas = new ArrayList<>();
        listaArtistas.add("penelope cruz");
        listaArtistas.add("antoni banderas");
        listaArtistas.add("vicente fernandez");
        listaArtistas.add("celia cruz");
        System.out.println("lista desordenada: " + listaArtistas);
        Collections.sort(listaArtistas);
        System.out.println("Lista ordenada: " + listaArtistas);

        Collections.sort(lista);
        System.out.println("lista ordenada: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);

        //hashmap

        Map<List, Integer> listaPeli = new HashMap<>();
        listaPeli.put(lista, 0);
        System.out.println("HashMap: " + listaPeli);


    }
}
