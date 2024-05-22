package com.literalura.dto;

public record AutorDTO(
       String nombre,
       Integer ano_nacimiento,
       Integer ano_muerte
){}



/*clase original sin dto
    private void mostrarAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();
        for(Autor autor : autores){
            System.out.println(
                    "==============================================================================" + '\n' +
                    "Autor : " + autor.getNombre() + '\n' +
                    "Fecha nacimiento: " + autor.getAno_nacimiento() + '\n' +
                    "Fecha fallecimiento: " + autor.getAno_muerte() + '\n');
            System.out.println("Libros: ");
            for(Libro libro : autor.getLibros()){
                System.out.println(" - " + cortarTitulo(libro.getTitulo()));
            }
        }
    }*/