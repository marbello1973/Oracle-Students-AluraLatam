package com.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorRecord(
        //@JsonAlias("id") Long id,
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer ano_nacimiento,
        @JsonAlias("death_year") Integer ano_muerte

){}
/*
"authors": [
        {
        "name": "Dickens, Charles",
        "birth_year": 1812,
        "death_year": 1870
        }

 */