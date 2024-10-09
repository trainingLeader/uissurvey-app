package com.uissurvey.uissurvey_app.infrastructure.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uissurvey.uissurvey_app.application.services.ISurveyService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String>{

    @Autowired
    private ISurveyService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if (service == null) {
            return true;
        }
        return !service.existsByName(value);
    }
}
