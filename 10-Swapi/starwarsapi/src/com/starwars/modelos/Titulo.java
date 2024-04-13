package com.starwars.modelos;

public class Titulo {
    private String title;
    private String director;
    private String producer;
    private String release_date;
    private String episode_id;


    public Titulo(String title, String director, String producer, String release_date, String episode_id) {
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.episode_id = episode_id;
    }

    public Titulo() {
    }

    public Titulo(TituloOmdb tituloOmdb) {

    }

    @Override
    public String toString() {
        return "(" +
                "Titulo: " +
                "title: " + title +
                ", director: " + director +
                ", producer: " + producer +
                ", release_date: " + release_date +
                ", episode_id: " + episode_id + ")";
    }
}
