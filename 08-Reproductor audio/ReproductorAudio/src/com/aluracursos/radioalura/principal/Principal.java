package com.aluracursos.radioalura.principal;

import com.aluracursos.radioalura.modelos.Cancion;
import com.aluracursos.radioalura.modelos.MisFavoritos;
import com.aluracursos.radioalura.modelos.Podcats;

public class Principal {
    public static void main(String[] args) {

        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Forever");
        miCancion.setCantante("Kiss");

        for (int i = 0; i < 500 ; i++) {
            miCancion.reproduce();
        }

        for (int i = 0; i < 1000 ; i++) {
            miCancion.meGusta();
        }

        System.out.println("Titulo reproducido " + miCancion.getTotalDeReproducciones());
        System.out.println("Me gustan " + miCancion.getTotalDeMeGusta());

        Podcats miPodcats = new Podcats();
        miPodcats.setPresentador("Gabriela Aguiar");
        miPodcats.setTitulo("Cafe.Tech");

        for (int i = 0; i < 1500 ; i++) {
            miPodcats.reproduce();
        }

        for (int i = 0; i < 500 ; i++) {
            miPodcats.meGusta();
        }

        System.out.println("Titulo reproducido " + miPodcats.getTotalDeReproducciones());
        System.out.println("Me gustan " + miPodcats.getTotalDeMeGusta());

        MisFavoritos misFavoritos = new MisFavoritos();
        misFavoritos.adicione(miPodcats);
        misFavoritos.adicione(miCancion);


    }
}
