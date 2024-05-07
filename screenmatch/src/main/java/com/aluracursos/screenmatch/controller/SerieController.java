package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDto;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;

    @GetMapping()
    public List<SerieDto> obtenerTodasLasSeries() {
        return service.obtenerTodasLasSeries();
    }

    @GetMapping("/top5")
    public List<SerieDto> obtenerTop5() {
        return service.obtenerTop5Series();
    }

    @GetMapping("/{id}")
    public SerieDto obtenerSeriePorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/lanzamientos")
    public List<SerieDto> obtenerLanzamientosMasRecientes() {
        return service.obtenerLanzamientosMasRecientes();
    }
}
