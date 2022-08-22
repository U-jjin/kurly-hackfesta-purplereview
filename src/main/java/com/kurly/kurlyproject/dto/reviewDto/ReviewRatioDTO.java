package com.kurly.kurlyproject.dto.reviewDto;

import com.kurly.kurlyproject.vo.FormatVO;
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
        for(Double d: list){this.ratiolist.add(FormatVO.form.format((d/sum)*100.0));}
    }
}
