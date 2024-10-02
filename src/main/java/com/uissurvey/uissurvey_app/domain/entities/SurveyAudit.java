package com.uissurvey.uissurvey_app.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class SurveyAudit {
    @Column(name = "surveycreated_at")
    private LocalDateTime surveycreatedAt;
    @Column(name = "surveyupdated_at")
    private LocalDateTime surveyupdatedAt;
    
    @PrePersist
    public void prePersistAudit() {
        surveycreatedAt = LocalDateTime.now();
        surveyupdatedAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdateAudit() {
        surveyupdatedAt = LocalDateTime.now();
    }
    public LocalDateTime getSurveycreatedAt() {
        return surveycreatedAt;
    }
    public void setSurveycreatedAt(LocalDateTime createdAt) {
        this.surveycreatedAt = createdAt;
    }
    public LocalDateTime getSurveyupdatedAt() {
        return surveyupdatedAt;
    }
    public void setSurveyupdatedAt(LocalDateTime updatedAt) {
        this.surveyupdatedAt = updatedAt;
    } 
}
