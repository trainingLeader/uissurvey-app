package com.uissurvey.uissurvey_app.application.services;

import java.util.List;
import java.util.Optional;

import com.uissurvey.uissurvey_app.domain.entities.Survey;

public interface ISurveyService {
    List<Survey> findAll();

    Optional<Survey> findById(Long id);

    Survey save(Survey survey);
    
    Optional<Survey> update(Long id, Survey survey);

    Optional<Survey> delete(Long id);

    boolean existsByName(String name);
}
