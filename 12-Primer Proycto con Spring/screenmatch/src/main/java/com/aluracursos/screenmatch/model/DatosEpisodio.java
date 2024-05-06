package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Year") String añoPublicacion,
        @JsonAlias("Rated") String clasificacion,
        @JsonAlias("Released") String fechaDelanzamiento,
        @JsonAlias("Runtime") String duracion,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Director") String director,
        @JsonAlias("Writer") String escritor,
        @JsonAlias("Actors") String actores,
        @JsonAlias("Plot") String trama,
        @JsonAlias("Language") String idioma,
        @JsonAlias("Country") String pais,
        @JsonAlias("Awards") String premios,
        @JsonAlias("Poster") String url_media,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Type") String tipo,
        @JsonAlias("Episode") Integer numeroEpisodio

) {
}
