package com.literalura.repository;

import com.literalura.modelos.Autor;
import com.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByTitulo(String titulo);

}
