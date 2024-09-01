package com.uissurvey.uissurvey_app.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@EqualsAndHashCode(exclude = {"questions"})
@ToString(exclude = {"questions"})
@Table(name = "chapters")
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String chapterNumber;
    @Column(columnDefinition = "text", nullable = false)
    private String chapterTitle;

    @Column(length = 20, nullable = true)
    private String componenthtml;

    @Column(length = 20, nullable = true)
    private String componentreact;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id")
    private List<Question> questions;

    @Embedded
    Audit audit = new Audit();

    public Chapter() {
    }

}
