package com.uissurvey.uissurvey_app.domain.entities;

import java.util.HashSet;
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
@EqualsAndHashCode(exclude = {"questions"})
@ToString(exclude = {"questions"})
@Table(name = "chapters")
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="chapter_number",length = 50, nullable = false)
    @NotNull(message = "El chapter Number es requerido")
    private String chapterNumber;

    @Column(name="chapter_title",columnDefinition = "text", nullable = false)
    @NotNull(message = "El titulo del capitulo no puede ser vacio")
    private String chapterTitle;

    @Column(length = 20, nullable = true)
    private String componenthtml;

    @Column(length = 20, nullable = true)
    private String componentreact;


    @OneToMany(mappedBy = "chapters",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Question> questions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    Survey survey;

    @Embedded
    Audit audit = new Audit();

    public Chapter() {
    }

}
