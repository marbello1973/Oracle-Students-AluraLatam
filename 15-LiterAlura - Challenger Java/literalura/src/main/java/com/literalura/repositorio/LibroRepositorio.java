package com.literalura.repositorio;

import com.literalura.modelos.Autor;
import com.literalura.modelos.Lenguaje;
import com.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l JOIN l.autor a WHERE l.titulo = :titulo AND a.nombre = :nombreAutor")
    Optional<Libro> findByTituloAndAutor(@Param("titulo") String titulo, @Param("nombreAutor") String nombreAutor);

    List<Libro> findByLenguaje(Lenguaje lenguaje);
}
