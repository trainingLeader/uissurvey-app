package com.uissurvey.uissurvey_app.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uissurvey.uissurvey_app.application.services.ISurveyAnswerService;
import com.uissurvey.uissurvey_app.domain.dtos.SurveyAnswerDto;
import com.uissurvey.uissurvey_app.domain.entities.SurveyAnswer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/surveyanswer")
public class SurveyAnswerController {
    @Autowired
    private ISurveyAnswerService surveyanswer;

    // @GetMapping
    // public ResponseEntity<Page<SurveyAnswer>> findAll(Pageable pageable){

    //     Page<SurveyAnswer> surveyPage = surveyanswer.findAll(pageable);

    //     if(surveyPage.hasContent()){
    //         return ResponseEntity.ok(surveyPage);
    //     }
    //     return ResponseEntity.ok(surveyPage);

    //     // return ResponseEntity.notFound().build();
    // }
    @GetMapping
    public List<SurveyAnswer> list() {
        return surveyanswer.findAll();
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody SurveyAnswerDto surveyjson, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(surveyanswer.createOne(surveyjson));
    }
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
