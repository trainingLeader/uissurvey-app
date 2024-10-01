package com.uissurvey.uissurvey_app.infrastructure.repositories.CategoryOptionResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uissurvey.uissurvey_app.domain.entities.CategoryOptionResponse;
import com.uissurvey.uissurvey_app.domain.entities.fkClass.CategoryOptionResponseId;

@Repository
public interface CategoryOptionRespRepository extends JpaRepository<CategoryOptionResponse,CategoryOptionResponseId> {

}
