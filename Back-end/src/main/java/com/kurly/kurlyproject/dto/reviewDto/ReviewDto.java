package com.kurly.kurlyproject.dto.reviewDto;

import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;
@Getter

/*
 Post 리뷰 생성을 위하여 담을 리뷰 데이터 객체
 */

public class ReviewDto {
    private Long reviewId;
    private LocalDateTime date;
    private String memberName;
    private String content;
    private int star;
    private List<KeywordReviewDTO> keywordReviews;


    public ReviewDto(Long reviewId, LocalDateTime date, String memberName, String content, int star, List<KeywordReviewDTO> keywordReviews) {
        this.reviewId = reviewId;
        this.date = date;
        this.memberName = memberName;
        this.content = content;
        this.star = star;
        this.keywordReviews = keywordReviews;
    }
}
