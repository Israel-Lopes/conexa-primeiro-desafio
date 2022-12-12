package com.example.conexaPrimeiroDesafio.service;

import com.example.conexaPrimeiroDesafio.integration.FilmCatalogIntegration;
import com.example.conexaPrimeiroDesafio.integration.PeopleCatalogIntegration;
import com.example.conexaPrimeiroDesafio.service.model.Film;
import com.example.conexaPrimeiroDesafio.service.model.catalog.PeopleCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieLukeSkyWalkerService {
    public static final Logger log = LoggerFactory.getLogger(MovieLukeSkyWalkerService.class);

    private static String NAME = "Luke Skywalker";
    @Autowired(required=true)
    private FilmCatalogIntegration filmIntegration;
    @Autowired(required=true)
    private PeopleCatalogIntegration peopleIntegration;

    public List<Film> getMoviesSkyWalker() {
        PeopleCatalog peoples = peopleIntegration.getPeople();

        List<String> moviesSky = peoples.getResults()
                .stream()
                .filter(people -> people.getName().equals(NAME))
                .flatMap(people -> people.getFilms().stream())
                .map(filmUrl -> filmUrl.substring(28, 29))
                .collect(Collectors.toList());

        log.info("Parametros de busca para films: {}", moviesSky);

        if (moviesSky.isEmpty()) {
            log.info("Nao foram encontrados filmes do personagem ", NAME);
            return Collections.emptyList();
        }

        return moviesSky.stream()
                .map(id -> filmIntegration.getFilmById(Integer.parseInt(id)))
                .collect(Collectors.toList());
    }
}
