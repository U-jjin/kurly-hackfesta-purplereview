package com.kurly.kurlyproject.domain.review;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Question {


    @Id
    @GeneratedValue
    @Column(name="question_id")
    private Long id;

    private String asking;

    //질문 에넘을 따로 할건지 String으로 파싱할건지 물어야겠따.
//    private ArrayList<String> answers =new ArrayList<>();





}
