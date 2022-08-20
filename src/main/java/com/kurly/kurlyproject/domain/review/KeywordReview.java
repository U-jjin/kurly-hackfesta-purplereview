package com.kurly.kurlyproject.domain.review;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class KeywordReview {

    @Id
    @GeneratedValue
    @Column(name="keyword_review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    private String answer;


    /*
    연관관계 메소드
    */
    public void addQuestion(Question question){
        this.question =question;
        question.getKeywordReviewList().add(this);
    }

    public void addReview(Review review){
        this.review =review;
        review.getKeywordReviewList().add(this);
    }



}
