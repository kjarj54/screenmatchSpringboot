package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDto;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {
    @Autowired
    private SerieService service;

    @GetMapping("/series")
    public List<SerieDto> obtenerTodasLasSeries() {
        return service.obtenerTodasLasSeries();
    }
}
