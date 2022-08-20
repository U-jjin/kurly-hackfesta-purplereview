package com.kurly.kurlyproject.dto;

import com.kurly.kurlyproject.domain.review.DeliverySatisfaction;

import java.util.Date;
import java.util.*;

public class ReviewDTO {

    private Long id;
    private Date date;
    private String memberId;
    private Long itemId;
    private String content;
    private int star;
    private DeliverySatisfaction deliverySatisfaction;
    private List<KeywordReviewDTO> keywordReviews;

    public ReviewDTO(Long id, Date date, String memberId, Long itemId, String content, int star, DeliverySatisfaction deliverySatisfaction, List<KeywordReviewDTO> keywordReviews) {
        this.id = id;
        this.date = date;
        this.memberId = memberId;
        this.itemId = itemId;
        this.content = content;
        this.star = star;
        this.deliverySatisfaction = deliverySatisfaction;
        this.keywordReviews = keywordReviews;
    }
}
