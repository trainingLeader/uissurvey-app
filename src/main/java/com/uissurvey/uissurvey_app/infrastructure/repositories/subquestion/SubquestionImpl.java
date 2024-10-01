package com.uissurvey.uissurvey_app.infrastructure.repositories.subquestion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uissurvey.uissurvey_app.application.services.ISubquestionService;
import com.uissurvey.uissurvey_app.domain.entities.SubQuestion;

@Service
public class SubquestionImpl implements ISubquestionService {

    @Autowired
    private SubquestionRepository subquestionRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<SubQuestion> findAll() {
        return (List<SubQuestion>) subquestionRepository.findAll();    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SubQuestion> findById(Long id) {
        return subquestionRepository.findById(id);
    }

    @Override
    @Transactional
    public SubQuestion save(SubQuestion subquestion) {
        return subquestionRepository.save(subquestion);
    }

    @Override
    @Transactional
    public Optional<SubQuestion> update(Long id, SubQuestion subquestion) {
        Optional<SubQuestion> subquestionOptional = subquestionRepository.findById(id);
        if (subquestionOptional.isPresent()) {
            SubQuestion subquestionDb = subquestionOptional.orElseThrow();
            subquestionDb.setSubquestiontext(subquestion.getSubquestiontext());
            subquestionDb.setSubquestionNumber(subquestion.getSubquestionNumber());
            subquestionDb.setCommentsubquestion(subquestion.getCommentsubquestion());
            return Optional.of(subquestionRepository.save(subquestionDb));
            
        }
        return subquestionOptional;
    }

    @Override
    public Optional<SubQuestion> delete(Long id) {
        Optional<SubQuestion> productOptional = subquestionRepository.findById(id);
        productOptional.ifPresent(subquestionDb -> {
            subquestionRepository.delete(subquestionDb);
        });
        return productOptional;
    }

}
