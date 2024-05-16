package com.literalura.repository;

import com.literalura.modelos.Autor;
import com.literalura.modelos.AutorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);

}
