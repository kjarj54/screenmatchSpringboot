package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.principal.EjemploStreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Hello World pero desde spring boot!");
//		var consumoApi = new ConsumoAPI();
//		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&&apikey=d8a223f3");
//		//json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
//
//		ConvierteDatos conversor = new ConvierteDatos();
//		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//	}

	@Autowired
	private SerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
