package com.kurly.kurlyproject.dto.reviewDto;

import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.*;
@Getter

public class GetReviewDto {
    private Long id;
    private LocalDateTime date;
    private String memberName;
    private String content;
    private int star;
    private List<KeywordReviewDTO> keywordReviews;


    public GetReviewDto(Long id, LocalDateTime date, String memberName, String content, int star, List<KeywordReviewDTO> keywordReviews) {
        this.id = id;
        this.date = date;
        this.memberName = memberName;
        this.content = content;
        this.star = star;
        this.keywordReviews = keywordReviews;
    }
}
