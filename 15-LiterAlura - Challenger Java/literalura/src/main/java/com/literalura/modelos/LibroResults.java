package com.literalura.modelos;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
public record LibroResults(
        @JsonAlias("count") Long contador,
        @JsonAlias("next") String siguiente,
        @JsonAlias("previous") String previo,
        @JsonAlias("results") List<LibroRecord> libroRecords
) {}
