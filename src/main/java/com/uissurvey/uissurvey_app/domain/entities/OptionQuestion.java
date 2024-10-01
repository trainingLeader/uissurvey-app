package com.uissurvey.uissurvey_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "option_questions")
public class OptionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = true)
    @NotNull(message = "El Number Option es obligatorio")
    private String numberoption;

    @Column(columnDefinition = "text", nullable = false)
    String commentoptionres;
    
    @ManyToOne
    @JoinColumn(name = "subquestion_id")
    @JsonBackReference
    SubQuestion subquestion;

    @ManyToOne
    @JoinColumn(name = "optionquestion_id")
    @JsonBackReference
    Question question;

    @ManyToOne
    @JoinColumn(name = "option_id")
    @JsonBackReference
    OptionResponse optionResponse;

    @Embedded
    Audit audit = new Audit();
}
