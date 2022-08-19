package com.kurly.kurlyproject.domain.review;


import javax.persistence.*;

@Entity
public class KeywordReview {

    @Id
    @GeneratedValue
    @Column(name="keyword_review_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id")
    private Review review;

    private Question question;




}
