package com.example.conexaPrimeiroDesafio.service.model.catalog;

import com.example.conexaPrimeiroDesafio.service.model.Film;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class FilmCatalog {
    private List<Film> results;
}
