package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action", "Accion"),
    AVENTURA("Adventure", "Aventura"),
    FANTASIA("Fantasy", "Fantasia"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crimen");

    private String categoriaOmdb;
    private String categoriaOmdbEspanol;

        Categoria (String categoriaOmdb, String categoriaOmdbEspanol){
            this.categoriaOmdb = categoriaOmdb;
            this.categoriaOmdbEspanol = categoriaOmdbEspanol;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Categoria fromEspañol(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdbEspanol.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

}
