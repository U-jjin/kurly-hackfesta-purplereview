package com.kurly.kurlyproject.dto;

import lombok.Getter;

@Getter
public
class KeywordReviewDTO {
    private Long questionId;
    private String question;
    private String answer;

    public KeywordReviewDTO(Long questionId, String question, String answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }
}
