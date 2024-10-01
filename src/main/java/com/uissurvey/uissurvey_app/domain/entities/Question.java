package com.uissurvey.uissurvey_app.domain.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"subquestions","optionquestion"})
@ToString(exclude = {"subquestions","optionquestion"})
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="question_number",length = 10, nullable = true)
    @NotNull(message = "El number de la Question es requerido")
    private String questionNumber;

    @Column(length = 10, nullable = true)
    private String response_type;

    @Column(columnDefinition = "text", nullable = false)
    @NotNull(message = "El texto de la pregunta es obligatoria")
    private String questionText;

    @Column(name="comment_question",columnDefinition = "text", nullable = true)
    private String commentquestion;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "optionquestion_id")
    private List<OptionQuestion> optionquestion;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    @JsonBackReference
    Chapter chapters;

    @OneToMany(mappedBy = "questions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<SubQuestion> subquestions = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<OptionQuestion> optionsQuestions = new HashSet<>();   

    @Embedded
    Audit audit = new Audit();

}
