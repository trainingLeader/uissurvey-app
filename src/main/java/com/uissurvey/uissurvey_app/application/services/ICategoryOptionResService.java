package com.uissurvey.uissurvey_app.application.services;

import java.util.List;
import java.util.Optional;

import com.uissurvey.uissurvey_app.domain.entities.CategoryOptionResponse;
import com.uissurvey.uissurvey_app.domain.entities.fkClass.CategoryOptionResponseId;

public interface ICategoryOptionResService {
    List<CategoryOptionResponse> findAll();

    Optional<CategoryOptionResponse> findById(CategoryOptionResponseId id);

    CategoryOptionResponse save(CategoryOptionResponse categoryoptresp);
    
    Optional<CategoryOptionResponse> update(CategoryOptionResponseId id, CategoryOptionResponse chapter);

    Optional<CategoryOptionResponse> delete(CategoryOptionResponseId id);
}
