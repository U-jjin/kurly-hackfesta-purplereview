package com.kurly.kurlyproject.dto.rateDTO;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.*;
@Getter@Setter
public class ReviewRatioDTO {
    private String asking;
    private String category;
    private List<String> answerlist;
    private List<String> ratiolist;

    public ReviewRatioDTO (String question, List<String> answerlist, List<Double> list, double sum) {

        String[] str = question.split("&");
        this.category =str[0];
        this.asking =str[1];
        this.answerlist = answerlist;

        this.ratiolist = new ArrayList<>();
        for(Double d: list){
            this.ratiolist.add( String.format("%.2f", (float)(d/sum*100)));
        }
    }
}
