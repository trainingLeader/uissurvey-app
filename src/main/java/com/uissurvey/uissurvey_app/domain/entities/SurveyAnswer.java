package com.uissurvey.uissurvey_app.domain.entities;

import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "surveys_answers")
@Entity
public class SurveyAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "surveyanswer_id")
    @JsonBackReference
    Survey surveysanswers;

    @Embedded
    SurveyAudit auditsurvey = new SurveyAudit();

    @JdbcTypeCode( SqlTypes.JSON )
    private Map<String, Object> payload;

    public SurveyAnswer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Survey getSurveysanswers() {
        return surveysanswers;
    }

    public void setSurveysanswers(Survey surveysanswers) {
        this.surveysanswers = surveysanswers;
    }

    public SurveyAudit getAuditsurvey() {
        return auditsurvey;
    }

    public void setAuditsurvey(SurveyAudit auditsurvey) {
        this.auditsurvey = auditsurvey;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
    
}
