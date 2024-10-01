package com.uissurvey.uissurvey_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "categories_catalog")
@Entity
public class Categorycatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @OneToMany(mappedBy = "categoryCatalog",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CategoryOptionResponse> categoriesoptionResponse = new HashSet<>();

    @Embedded
    Audit audit = new Audit();

}
