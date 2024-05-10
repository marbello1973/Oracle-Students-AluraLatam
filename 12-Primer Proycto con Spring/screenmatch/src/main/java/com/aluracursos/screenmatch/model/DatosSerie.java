package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
       @JsonAlias("Title") String titulo,
       @JsonAlias("totalSeasons") Integer totalDeTemporadas,
       @JsonAlias("imdbRating") String evaluacion,
       @JsonAlias("Year") String añoPublicacion,
       @JsonAlias("Rated") String clasificacion,
       @JsonAlias("Released") String fechaDelanzamiento,
       @JsonAlias("Runtime") String duracion,
       @JsonAlias("Genre") String genero,
       @JsonAlias("Director") String director,
       @JsonAlias("Writer") String escritor,
       @JsonAlias("Actors") String actores,
       @JsonAlias("Plot") String sinopsis,
       @JsonAlias("Language") String idioma,
       @JsonAlias("Country") String pais,
       @JsonAlias("Awards") String premios,
       @JsonAlias("Poster") String poster,
       @JsonAlias("Type") String tipo,
       @JsonAlias("Episode") Integer numeroEpisodio


) {}


