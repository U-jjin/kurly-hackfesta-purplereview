package com.kurly.kurlyproject.domain.review;

import java.util.ArrayList;
import java.util.List;

import com.kurly.kurlyproject.domain.category.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Question {


    @Id
    @GeneratedValue
    @Column(name="question_id")
    private Long id;

    private String asking;

    private String answers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<KeywordReview> keywordReviewList =new ArrayList<>();


    /*
     연관관계 메소드
     */

    public void addCategory(Category category){
        this.category =category;
        category.getQuestionList().add(this);
    }



}
