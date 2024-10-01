package com.uissurvey.uissurvey_app.infrastructure.repositories.chapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uissurvey.uissurvey_app.application.services.IChapterService;
import com.uissurvey.uissurvey_app.domain.entities.Chapter;

@Service
public class ChapterImpl implements IChapterService {

    @Autowired
    private ChapterRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Chapter> findAll() {
        return (List<Chapter>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Chapter> findById(Long id) {
        return repository.findById(id);    
    }

    @Override
    @Transactional
    public Chapter save(Chapter chapter) {
        return repository.save(chapter);    }

    @Override
    @Transactional
    public Optional<Chapter> update(Long id, Chapter chapter) {
        Optional<Chapter> chapterOptional = repository.findById(id);
        if (chapterOptional.isPresent()) {
            Chapter chapterDb = chapterOptional.orElseThrow();
            chapterDb.setChapterTitle(chapter.getChapterTitle());
            chapterDb.setChapterNumber(chapter.getChapterNumber());
            chapterDb.setComponenthtml(chapter.getComponenthtml());
            chapterDb.setComponentreact(chapter.getComponenthtml());
            return Optional.of(repository.save(chapterDb));
        }
        return chapterOptional;
    }

    @Override
    public Optional<Chapter> delete(Long id) {
        Optional<Chapter> productOptional = repository.findById(id);
        productOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productOptional;
    }

}
