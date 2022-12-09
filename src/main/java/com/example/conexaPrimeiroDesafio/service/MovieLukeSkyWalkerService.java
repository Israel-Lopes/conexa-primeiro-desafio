package com.example.conexaPrimeiroDesafio.service;

import com.example.conexaPrimeiroDesafio.integration.FilmCatalogIntegration;
import com.example.conexaPrimeiroDesafio.integration.PeopleCatalogIntegration;
import com.example.conexaPrimeiroDesafio.model.Film;
import com.example.conexaPrimeiroDesafio.model.catalog.PeopleCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieLukeSkyWalkerService {
    public static final Logger log = LoggerFactory.getLogger(MovieLukeSkyWalkerService.class);

    private static String NAME = "Luke Skywalker";
    @Autowired(required=true)
    private FilmCatalogIntegration filmIntegration;
    @Autowired(required=true)
    private PeopleCatalogIntegration peopleIntegration;

    public List<Film> getMoviesSkyWalker() {

        ArrayList<String> moviesSky = new ArrayList<>();
        PeopleCatalog peoples = peopleIntegration.getPeople();
        List<Film> skys = new ArrayList<>();

        for (int i = 0; i < peoples.getResults().size(); i++) {
            if (peoples.getResults().get(i).getName().equals(NAME)) {
                log.info("Parametros de busca para people: {}", NAME);
                for (int j = 0 ; j < peoples.getResults().get(i).getFilms().size(); j++) {
                    String id = peoples.getResults().get(i).getFilms().get(j).substring(28, 29);
                    moviesSky.add(j, id.toString());
                    log.info("Parametros de busca para films: {}", id.toString());
                }
                break;
            }
        }

        if (moviesSky.isEmpty()) {
            log.info("Nao foram encontrados filmes do personagem ", NAME);

            return null;
        }

        for (int i = 0; i < moviesSky.size(); i++) {
            Integer id = Integer.parseInt(moviesSky.get(i));
            log.info("Parametros de busca para films: {}", id.toString());
            skys.add(i, filmIntegration.getFilmById(id));
        }

        return skys;
    }
}
