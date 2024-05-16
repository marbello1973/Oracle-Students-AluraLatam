package com.literalura.modelos;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroRecord(
        @JsonAlias("id") Long id,
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<AutorRecord> autor,
        @JsonProperty("subjects") List<String> temas,
        @JsonProperty("languages") List<String> lenguajes,
        @JsonProperty("copyright") Boolean derechos_de_autor,
        @JsonProperty("media_type") String tipo_de_medio,
        @JsonAlias("download_count") Long contador_de_descargas
) {}
