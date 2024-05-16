package com.literalura.dto;

import java.util.List;

public record LibroDTO(
      Long id,
      String titulo,
      List<String> temas,
      List<String> lenguajes,
      Boolean derechos_de_autor,
      String tipo_de_medio,
      Long contador_de_descargas
){}
