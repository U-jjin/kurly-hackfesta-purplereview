package com.kurly.kurlyproject.dto.rateDTO;

import lombok.Getter;
import java.util.*;

/*
 키워드 리뷰별 질문 리스트 및 대답 데이터를 담기위한 객체
 */

@Getter
public class ReviewRatioDTO {
    private String asking;
    private String category;
    private List<String> answerlist;
    private List<String> ratiolist;

    public ReviewRatioDTO (String question, List<String> answerList, List<Double> list, double sum) {

        String[] str = question.split("&");
        this.category =str[0];
        this.asking =str[1];
        this.answerlist = answerList;

        this.ratiolist = new ArrayList<>();
        for(Double d: list){
            this.ratiolist.add( String.format("%.2f", (float)(d/sum*100)));
        }
    }
}
