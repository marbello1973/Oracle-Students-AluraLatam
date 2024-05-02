package com.ebook.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosDeAuthor(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Long birth_year ,
        @JsonAlias("death_year") Long death_year
){}

