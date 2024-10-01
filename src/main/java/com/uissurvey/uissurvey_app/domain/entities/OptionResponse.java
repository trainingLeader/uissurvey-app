package com.uissurvey.uissurvey_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

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
@EqualsAndHashCode(exclude = {"categoriesoptionResponse"})
@ToString(exclude = {"categoriesoptionResponse"})
@Entity
@Table(name = "options_response")
public class OptionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = true)
    @NotNull(message = "El texto de la opcion es obligatoria")
    private String optiontext;

    @Column(name = "type_option",length = 50, nullable = true)
    @NotNull(message = "El tipo de opcion es requerido no puede se nulo")
    private String typeoption;

    @OneToMany(mappedBy = "optionResponse",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CategoryOptionResponse> categoriesoptionResponse = new HashSet<>();

    @Embedded
    Audit audit = new Audit();


}
