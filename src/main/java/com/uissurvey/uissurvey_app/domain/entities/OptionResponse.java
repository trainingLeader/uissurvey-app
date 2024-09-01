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
@Entity
@EqualsAndHashCode(exclude = {"options","categoriesoptions"})
@ToString(exclude = {"options","categoriesoptions"})
@Table(name = "options_response")
public class OptionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = true)
    private String optiontext;

    @Column(name = "type_option",length = 50, nullable = true)
    private String typeoption;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "option_id")
    private List<OptionQuestion> options;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "categoriesoptions_id")
    private List<CategoryOption> categoriesoptions;

    @Embedded
    Audit audit = new Audit();


}
