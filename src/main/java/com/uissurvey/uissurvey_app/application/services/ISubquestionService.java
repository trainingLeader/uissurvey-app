package com.uissurvey.uissurvey_app.application.services;

import java.util.List;
import java.util.Optional;

import com.uissurvey.uissurvey_app.domain.entities.SubQuestion;



public interface ISubquestionService {
    List<SubQuestion> findAll();

    Optional<SubQuestion> findById(Long id);

    SubQuestion save(SubQuestion subquestion);
    
    Optional<SubQuestion> update(Long id, SubQuestion subquestion);

    Optional<SubQuestion> delete(Long id);
}
