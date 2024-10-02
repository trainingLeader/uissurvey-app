package com.uissurvey.uissurvey_app.infrastructure.repositories.surveyanswer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uissurvey.uissurvey_app.domain.entities.SurveyAnswer;

public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer,Long> {

}
