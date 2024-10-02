package com.uissurvey.uissurvey_app.domain.dtos;

import java.util.Map;

import lombok.Data;

@Data
public class SurveyAnswerDto {
    private Long id;
    private Long surveyid;
    private Map<String, Object> payload;
}
