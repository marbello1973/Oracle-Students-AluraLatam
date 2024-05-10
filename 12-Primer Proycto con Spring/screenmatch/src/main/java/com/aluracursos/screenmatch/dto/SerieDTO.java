package com.aluracursos.screenmatch.dto;

public record SerieDTO(
       Long id,
       String titulo,
       Integer totalDeTemporadas,
       Double evaluacion,
       String poster,
       String clasificacion,
       String actores,
       String sinopsis

) {
}
