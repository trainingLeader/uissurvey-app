package com.uissurvey.uissurvey_app.infrastructure.repositories.surveyanswer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uissurvey.uissurvey_app.application.services.ISurveyAnswerService;
import com.uissurvey.uissurvey_app.domain.dtos.SurveyAnswerDto;
import com.uissurvey.uissurvey_app.domain.entities.Survey;
import com.uissurvey.uissurvey_app.domain.entities.SurveyAnswer;

@Service
public class SurveyAnswerImpl implements ISurveyAnswerService {

    @Autowired
    private SurveyAnswerRepository repository;
    
    
    @Override
    @Transactional(readOnly = true)
    public Optional<SurveyAnswer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SurveyAnswer> findAll() {
        return repository.findAll();
    }
    
    @Override
    @Transactional
    public SurveyAnswerDto createOne(SurveyAnswerDto surveyanswer) {
        SurveyAnswer surveyJsonUpdate = new SurveyAnswer();
        surveyJsonUpdate.setPayload(surveyanswer.getPayload()); 
        Survey survey = new Survey();
        survey.setId(surveyanswer.getSurveyid());

        surveyJsonUpdate.setSurveysanswers(survey);

        SurveyAnswer savedSurveyAnswer = repository.save(surveyJsonUpdate);
        surveyanswer.setId(savedSurveyAnswer.getId());
        
        return surveyanswer;
    }


}
