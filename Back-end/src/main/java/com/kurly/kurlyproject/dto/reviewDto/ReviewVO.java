package com.kurly.kurlyproject.dto.reviewDto;

import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ReviewVO {

    private Long memberId;
    private String itemContent;
    private String deliveryContent;
    private int star;
    private String deliverySatisfaction;
    private List<Map<String,String>> keywordReviews;


    public ReviewVO(Long memberId, String itemContent, String deliveryContent, int star, String deliverySatisfaction, List<Map<String,String>> keywordReviews) {
        this.memberId = memberId;
        this.itemContent = itemContent;
        this.deliveryContent = deliveryContent;
        this.star = star;
        this.deliverySatisfaction = deliverySatisfaction;
        this.keywordReviews = keywordReviews;
    }
}
