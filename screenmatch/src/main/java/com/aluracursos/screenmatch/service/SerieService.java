package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.EpisodioDto;
import com.aluracursos.screenmatch.dto.SerieDto;
import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDto> obtenerTodasLasSeries() {
        return convierteDatos(repository.findAll());
    }

    public List<SerieDto> obtenerTop5Series() {
        return convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());

    }

    public List<SerieDto> obtenerLanzamientosMasRecientes() {
        return convierteDatos(repository.lanzamientosMasRecientes());
    }

    public List<SerieDto> convierteDatos(List<Serie> serie){
        return serie.stream()
                .map(s-> new SerieDto(s.getId(),s.getTitulo(), s.getTotalTemporadas(), s.getEvaluacion(), s.getPoster()
                        , s.getGenero(), s.getActores(), s.getSinopsis()))
                .collect(Collectors.toList());
    }

    public SerieDto obtenerPorId(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return new SerieDto(s.getId(),s.getTitulo(), s.getTotalTemporadas(), s.getEvaluacion(), s.getPoster()
                    , s.getGenero(), s.getActores(), s.getSinopsis());
        }
        return null;
    }

    public List<EpisodioDto> obtenerTodasLasTemporadas(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e-> new EpisodioDto(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDto> obtenerTemporadasPorNumero(Long id, Long numeroTemporada) {
        return repository.obtenerTemporadasPorNumero(id,numeroTemporada)
                .stream().map(e-> new EpisodioDto(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
                .collect(Collectors.toList());
    }

    public List<SerieDto> obtenerSeriePorCategoria(String nombreGenero) {
        Categoria categoria = Categoria.fromEspanol(nombreGenero);
        return convierteDatos(repository.findByGenero(categoria));
    }
}
