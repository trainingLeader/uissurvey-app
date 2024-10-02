package com.uissurvey.uissurvey_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"chapters","answers"})
@ToString(exclude = {"chapters","answers"})
@Table(name = "surveys")
@JsonIgnoreProperties({"answers"})
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @Column(columnDefinition = "text", nullable = false)
    @NotNull(message = "La descripcion es obligatoria")
    private String description;
    
    @Column(columnDefinition = "text", nullable = true)
    @NotNull(message = "Las instrucciones son requeridas")
    private String instruction;

    @Column(length = 20, nullable = true)
    private String componenthtml;

    @Column(length = 20, nullable = true)
    private String componentreact;

    @OneToMany(mappedBy = "surveysanswers",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<SurveyAnswer> answers = new HashSet<>();

    @Embedded
    Audit audit = new Audit();

    @OneToMany( mappedBy="survey",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Chapter> chapters = new HashSet<>();

}
