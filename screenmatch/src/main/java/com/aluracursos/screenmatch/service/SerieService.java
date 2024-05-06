package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.SerieDto;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDto> obtenerTodasLasSeries() {
        return repository.findAll()
                .stream()
                .map(s-> new SerieDto(s.getTitulo(), s.getTotalTemporadas(), s.getEvaluacion(), s.getPoster()
                        , s.getGenero(), s.getActores(), s.getSinopsis()))
                .collect(Collectors.toList());
    }
}
