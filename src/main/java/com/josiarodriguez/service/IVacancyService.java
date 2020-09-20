package com.josiarodriguez.service;

import com.josiarodriguez.model.Vacancy;

import java.util.List;

public interface IVacancyService {
    List<Vacancy> searchAll();

    Vacancy searchById(Integer VacancyId);

    void save(Vacancy vacancy);
}
