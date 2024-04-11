package com.aluracursos.radioalura.modelos;

public class MisFavoritos {

    public void adicione(Audio audio){
        if (audio.getClasificaciones() >= 7){
            System.out.println(audio.getTitulo() + "Es favorito");
        }else {
            System.out.println("No esta en favoritos ");
        }
    }
}
