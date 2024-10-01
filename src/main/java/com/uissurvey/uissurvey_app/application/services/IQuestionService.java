package com.uissurvey.uissurvey_app.application.services;


import java.util.List;
import java.util.Optional;


import com.uissurvey.uissurvey_app.domain.entities.Chapter;
import com.uissurvey.uissurvey_app.domain.entities.Question;

public interface IQuestionService {
    List<Question> findAll();

    Optional<Question> findById(Long id);

    Chapter save(Question question);
    
    Optional<Question> update(Long id, Question question);

    Optional<Question> delete(Long id);
}
