package com.uissurvey.uissurvey_app.domain.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @Column(length = 10, nullable = true)
    private String questionNumber;

    @Column(length = 10, nullable = true)
    private String response_type;

    @Column(columnDefinition = "text", nullable = false)
    private String questionText;

    @Column(columnDefinition = "text", nullable = true)
    private String comment_question;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "subquestion_id")
    private List<SubQuestion> subquestions;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "optionquestion_id")
    private List<OptionQuestion> optionquestion;



    @Embedded
    Audit audit = new Audit();

}
