package com.example.conexaPrimeiroDesafio.integration;

import com.example.conexaPrimeiroDesafio.service.model.catalog.PeopleCatalog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url= "${integration.swapi.starwar}" , name = "people")
public interface PeopleCatalogIntegration {
    @RequestMapping(method = RequestMethod.GET, value = "/people")
    PeopleCatalog getPeople();
}
