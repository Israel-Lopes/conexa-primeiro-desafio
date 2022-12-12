package com.example.conexaPrimeiroDesafio.integration;

import com.example.conexaPrimeiroDesafio.service.model.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url= "${integration.swapi.starwar}" , name = "films")
public interface FilmCatalogIntegration {
    @RequestMapping(method = RequestMethod.GET, value = "/films/{id}")
    Film getFilmById(@PathVariable Integer id);
}

