package com.ebook.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosExtras(
        @JsonAlias("count") Integer contadorDeDescargas,
        @JsonAlias("next") String paginaSiguiente,
        @JsonAlias("previous") String paginaAnterior
) {}
