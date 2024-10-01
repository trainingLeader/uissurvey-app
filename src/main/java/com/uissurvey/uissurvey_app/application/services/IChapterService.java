package com.uissurvey.uissurvey_app.application.services;

import java.util.List;
import java.util.Optional;

import com.uissurvey.uissurvey_app.domain.entities.Chapter;

public interface IChapterService {
    List<Chapter> findAll();

    Optional<Chapter> findById(Long id);

    Chapter save(Chapter chapter);
    
    Optional<Chapter> update(Long id, Chapter chapter);

    Optional<Chapter> delete(Long id);
}
