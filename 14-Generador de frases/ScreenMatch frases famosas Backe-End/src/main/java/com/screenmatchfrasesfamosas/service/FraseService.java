package com.screenmatchfrasesfamosas.service;

import com.screenmatchfrasesfamosas.dto.FraseDTO;
import com.screenmatchfrasesfamosas.models.Frase;
import com.screenmatchfrasesfamosas.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repository;
    public FraseDTO obtenerFraseAleatoria() {
       Optional<Frase> fraseOptional = repository.obtenerFraseAleatoria();
       if(fraseOptional.isPresent()){
           Frase frase = fraseOptional.get();
           return new FraseDTO(
                   frase.getTitulo(),
                   frase.getFrase(),
                   frase.getPersonaje(),
                   frase.getPoster()
           );
       }
       return null;
    }
}
