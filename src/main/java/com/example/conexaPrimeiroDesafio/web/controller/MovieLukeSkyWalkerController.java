package com.example.conexaPrimeiroDesafio.web.controller;

import com.example.conexaPrimeiroDesafio.service.model.Film;
import com.example.conexaPrimeiroDesafio.service.MovieLukeSkyWalkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sky")
public class MovieLukeSkyWalkerController {
    public static final Logger log = LoggerFactory.getLogger(MovieLukeSkyWalkerController.class);
    @Autowired(required=true)
    MovieLukeSkyWalkerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Film> getSky() {
        log.info("Inciando busca para filmes do Skywalker");
        List<Film> films = service.getMoviesSkyWalker();
        return films;
    }
}
