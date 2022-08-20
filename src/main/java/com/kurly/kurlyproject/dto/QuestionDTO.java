package com.kurly.kurlyproject.dto;

import java.util.ArrayList;

public class QuestionDTO{

    private Long id;
    private String asking;
    private String [] answerlist;

    public QuestionDTO(Long id, String asking, String[] answerlist) {
        this.id = id;
        this.asking = asking;
        this.answerlist = answerlist;
    }
}
