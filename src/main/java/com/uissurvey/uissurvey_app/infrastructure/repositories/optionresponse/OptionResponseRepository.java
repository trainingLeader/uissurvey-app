package com.uissurvey.uissurvey_app.infrastructure.repositories.optionresponse;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uissurvey.uissurvey_app.domain.entities.OptionResponse;

public interface OptionResponseRepository extends JpaRepository<OptionResponse,Long> {

}
