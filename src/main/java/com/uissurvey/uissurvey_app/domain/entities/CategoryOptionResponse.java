package com.uissurvey.uissurvey_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uissurvey.uissurvey_app.domain.entities.fkClass.CategoryOptionResponseId;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "category_optionsresponse")
@Entity
@JsonIgnoreProperties({"categoryCatalog","optionResponse"})
public class CategoryOptionResponse {
    @EmbeddedId
    private CategoryOptionResponseId Id;

    @ManyToOne
    @JoinColumn(name = "categorycatalog_id",insertable = false,updatable = false)
    private Categorycatalog categoryCatalog;

    @ManyToOne
    @JoinColumn(name = "optionresponse_id",insertable = false,updatable = false)
    private OptionResponse optionResponse;

    @Embedded
    Audit audit = new Audit();

    public CategoryOptionResponse() {
    }
    
}
