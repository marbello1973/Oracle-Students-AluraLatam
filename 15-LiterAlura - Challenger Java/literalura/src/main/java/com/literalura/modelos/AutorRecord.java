package com.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorRecord(
        @JsonAlias("id") Long id,
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer año_de_nacimiento,
        @JsonAlias("death_year") Integer año_de_muerte
) {}
