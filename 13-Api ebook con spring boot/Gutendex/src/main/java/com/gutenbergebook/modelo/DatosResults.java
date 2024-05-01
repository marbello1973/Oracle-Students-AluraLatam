package com.gutenbergebook.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResults(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo
) {}
