package com.uissurvey.uissurvey_app.infrastructure.repositories.Survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.uissurvey.uissurvey_app.application.services.ISurveyService;
import com.uissurvey.uissurvey_app.domain.entities.Survey;

public class SurveryImpl implements ISurveyService {

    @Autowired
    private SurveyRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Survey> findAll() {
        return (List<Survey>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Survey> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    @Override
    public Optional<Survey> update(Long id, Survey survey) {
        Optional<Survey> productOptional = repository.findById(id);
        if (productOptional.isPresent()) {
            Survey surveyDb = productOptional.orElseThrow();
            surveyDb.setName(survey.getName());
            surveyDb.setInstruction(survey.getInstruction());
            surveyDb.setDescription(survey.getDescription());
            return Optional.of(repository.save(surveyDb));
            
        }
        return productOptional;
    }

    @Override
    public Optional<Survey> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
