package com.gutenbergebook.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosGutendex(
        @JsonAlias("count") Integer contadorLibros,
        @JsonAlias("next") String paginaSiguiente,
        @JsonAlias("previous") String paginaAnterior
) {}
