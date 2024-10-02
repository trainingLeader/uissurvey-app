package com.uissurvey.uissurvey_app.application.services;

import java.util.List;
import java.util.Optional;

import com.uissurvey.uissurvey_app.domain.dtos.SurveyAnswerDto;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

import com.uissurvey.uissurvey_app.domain.entities.SurveyAnswer;

public interface ISurveyAnswerService {
    // Page<SurveyAnswer> findAll(Pageable pageable);
    List<SurveyAnswer> findAll();
    Optional<SurveyAnswer> findById(Long id);
    SurveyAnswerDto createOne(SurveyAnswerDto surveyanswer);
}
