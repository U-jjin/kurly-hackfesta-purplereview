package com.kurly.kurlyproject.domain.review;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
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

    public static KeywordReview createKeywordReview(Question question, String answer) {
        KeywordReview key = new KeywordReview();

        key.addQuestion(question);
        key.setAnswer(answer);

        return  key;
    }

    /*
    연관관계 메소드
    */
    public void addQuestion(Question question){
        this.question =question;
        question.getKeywordReviewList().add(this);
    }

    public void addReview(Review review){
        this.review =review;

    }



}
