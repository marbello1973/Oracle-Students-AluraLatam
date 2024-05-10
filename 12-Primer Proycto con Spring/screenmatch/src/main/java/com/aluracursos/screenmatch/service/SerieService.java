package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;
    public List<SerieDTO> geAlltSeries() {//convertir serieDTO a tipo de dato serie
        return convertirDatosAlista(serieRepository.findAll());
    }
    public List<SerieDTO> obtenerTopCinco() {
        return convertirDatosAlista(serieRepository.findTop5ByOrderByEvaluacionDesc());
    }
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return convertirDatosAlista(serieRepository.lasnzamientoMasReciente());
    }
    public List<SerieDTO> convertirDatosAlista(List<Serie> serie){
        return serie.stream()
                .map(s -> new SerieDTO(
                        s.getId(),
                        s.getTitulo(),
                        s.getTotalDeTemporadas(),
                        s.getEvaluacion(),
                        s.getPoster(),
                        s.getClasificacion(),
                        s.getActores(),
                        s.getSinopsis()))
                .collect(Collectors.toList());
    }

    public SerieDTO obtenerPorId(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(
                    s.getId(),
                    s.getTitulo(),
                    s.getTotalDeTemporadas(),
                    s.getEvaluacion(),
                    s.getPoster(),
                    s.getClasificacion(),
                    s.getActores(),
                    s.getSinopsis()
            );
        }
        return null;
    }

    public List<EpisodioDTO> obtenerTodasLasTemporadas(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO(
                            e.getTemporada(),
                            e.getTitulo(),
                            e.getNumeroEpisodio(),
                            e.getEvaluacion(),
                            e.getFechaDeLanzamiento()))
                    .collect(Collectors.toList());
        }
        return null;
    }


    public List<EpisodioDTO> obtenerTemporadasPorNumero(Long id, Long numeroTemporada) {
        return serieRepository.obtenerTemporadasPorNumero(id, numeroTemporada).stream()
                .map(e -> new EpisodioDTO(
                        e.getTemporada(),
                        e.getTitulo(),
                        e.getNumeroEpisodio(),
                        e.getEvaluacion(),
                        e.getFechaDeLanzamiento()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obtenerSeriesPorCategoria(String nombreGenero) {
        Categoria categoria = Categoria.fromEspañol(nombreGenero);
        return convertirDatosAlista(serieRepository.findByGenero(categoria));
    }

    public List<EpisodioDTO> obtenerTopEpisodios(Long serieId) {
        return serieRepository.obtenerTopEpisodios(serieId).stream()
                .map(e -> new EpisodioDTO(
                        e.getTemporada(),
                        e.getTitulo(),
                        e.getNumeroEpisodio(),
                        e.getEvaluacion(),
                        e.getFechaDeLanzamiento()
                ))
                .collect(Collectors.toList());
    }
}
