package com.uissurvey.uissurvey_app.infrastructure.repositories.Survey;

import org.springframework.data.repository.CrudRepository;

import com.uissurvey.uissurvey_app.domain.entities.Survey;

public interface SurveyRepository extends CrudRepository<Survey,Long> {

}
