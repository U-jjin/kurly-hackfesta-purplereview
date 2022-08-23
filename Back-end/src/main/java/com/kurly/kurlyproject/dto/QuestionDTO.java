package com.kurly.kurlyproject.dto;

import lombok.Getter;
import java.util.ArrayList;
@Getter
public class QuestionDTO{
    private Long questionId;
    private String asking;
    private String[] answerlist;
    public QuestionDTO(Long questionId, String asking, String[] answerlist) {
        this.questionId = questionId;
        this.asking = asking;
        this.answerlist = answerlist;
    }
}
