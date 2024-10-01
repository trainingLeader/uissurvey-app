package com.uissurvey.uissurvey_app.infrastructure.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.uissurvey.uissurvey_app.application.services.ICategoryOptionResService;
import com.uissurvey.uissurvey_app.domain.entities.CategoryOptionResponse;

@RestController
@RequestMapping("/api/ct")
public class CategoryOptionResponseController {
    @Autowired
    private ICategoryOptionResService service;

    @GetMapping
    public List<CategoryOptionResponse> list() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createCategoryOptionResponse(@RequestBody CategoryOptionResponse categoryOptionResponse) {
    // CategoryOptionResponse createdResponse = service.save(categoryOptionResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoryOptionResponse));
    }
}
