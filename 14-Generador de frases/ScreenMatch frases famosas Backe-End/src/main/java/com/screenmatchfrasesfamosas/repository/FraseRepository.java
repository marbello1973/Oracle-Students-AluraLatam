package com.screenmatchfrasesfamosas.repository;

import com.screenmatchfrasesfamosas.models.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FraseRepository extends JpaRepository<Frase, Long> {
    @Query("SELECT f FROM Frase f ORDER BY function('RANDOM') LIMIT 1")
    Optional<Frase> obtenerFraseAleatoria();
}
