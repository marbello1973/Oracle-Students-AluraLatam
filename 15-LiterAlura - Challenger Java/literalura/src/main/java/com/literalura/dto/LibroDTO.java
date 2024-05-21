package com.literalura.dto;

import com.literalura.modelos.Lenguaje;

public record LibroDTO(
        String titulo,
        Lenguaje lenguaje,
        Long contador_descargas
){}
