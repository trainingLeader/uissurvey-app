package com.uissurvey.uissurvey_app.domain.entities.fkClass;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class CategoryOptionResponseId implements Serializable {
    
    @Column(name = "optionresponse_id")
    private Long optionresponseId;
    @Column(name = "categorycatalog_id")
    private Long categorycatalogId;

    public CategoryOptionResponseId() {}


  
}
