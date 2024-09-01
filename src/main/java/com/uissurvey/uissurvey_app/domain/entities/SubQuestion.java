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
@EqualsAndHashCode(exclude = {"subquestion"})
@ToString(exclude = {"subquestion"})
@Entity
@Table(name = "sub_questions")
public class SubQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String subquestiontext;

    @Column(name = "comment_subquestion",columnDefinition = "text", nullable = true)
    private String commentsubquestion;

    @Column(length = 10, nullable = true)
    private String subquestionNumber;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "subquestion_id")
    private List<OptionQuestion> subquestion;

    @Embedded
    Audit audit = new Audit();
}
