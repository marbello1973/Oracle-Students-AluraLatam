package com.literalura.servicio;

import com.literalura.dto.LibroDTO;
import com.literalura.modelos.Libro;
import com.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepository libroRepository;

    public List<LibroDTO> obtenerTodosLosLibros(){
        return convertirDatosAlista(libroRepository.findAll());
    }

    public List<LibroDTO> convertirDatosAlista(List<Libro> libros){
        return libros.stream()
                .map(l -> new LibroDTO(
                        l.getId(),
                        l.getTitulo(),
                        l.getTemas(),
                        l.getLenguajes(),
                        l.getDerechos_de_autor(),
                        l.getTipo_de_medio(),
                        l.getContador_de_descargas()
                )).collect(Collectors.toList());
    }
}
