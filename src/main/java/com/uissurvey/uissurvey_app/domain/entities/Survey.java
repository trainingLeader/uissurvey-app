package com.uissurvey.uissurvey_app.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"chapters"})
@ToString(exclude = {"chapters"})
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String name;

    @Column(columnDefinition = "text", nullable = false)
    private String description;
    
    @Column(columnDefinition = "text", nullable = true)
    private String instruction;

    @Column(length = 20, nullable = true)
    private String componenthtml;

    @Column(length = 20, nullable = true)
    private String componentreact;

    @Embedded
    Audit audit = new Audit();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    @JsonManagedReference
    private List<Chapter> chapters;



}
