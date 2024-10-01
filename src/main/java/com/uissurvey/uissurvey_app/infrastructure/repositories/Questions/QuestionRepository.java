package com.uissurvey.uissurvey_app.infrastructure.repositories.Questions;

import org.springframework.data.repository.CrudRepository;

import com.uissurvey.uissurvey_app.domain.entities.Question;

public interface QuestionRepository extends CrudRepository<Question,Long> {

}
