package com.kurly.kurlyproject.dto.reviewDto;

import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class PostReviewDto {
    private Long memberId;
    private String itemContent;
    private String deliveryContent;
    private int star;
    private String deliverySatisfaction;
    private List<KeywordReviewDTO> keywordReviews;

    public PostReviewDto(Long memberId, String content, String deliveryContent, int star, String deliverySatisfaction, List<KeywordReviewDTO> keywordReviews) {
        this.memberId = memberId;
        this.itemContent = content;
        this.deliveryContent = deliveryContent;
        this.star = star;
        this.deliverySatisfaction = deliverySatisfaction;
        this.keywordReviews = keywordReviews;
    }
}
