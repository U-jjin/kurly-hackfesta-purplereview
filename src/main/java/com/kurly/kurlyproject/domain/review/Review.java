package com.kurly.kurlyproject.domain.review;

import com.kurly.kurlyproject.domain.item.Item;
import com.kurly.kurlyproject.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue
    @Column(name="review_id")
    private Long id;

    @ManyToOne
    private Member member;

    private Item item;

    @Lob
    private String content;

    private int star;

    @Enumerated(EnumType.STRING)
    private DeliverySatisfaction deliverySatisfaction; // good, bad

    @OneToMany(mappedBy = "review")
    private List<KeywordReview> keywordReviews =new ArrayList<>();



    //리뷰 생성 키워드
    //이걸로 키워드 레코드도 생성시킨다.
    //오류 발생을 어떻게 할건지는 노의를 해봐야할 듯

}
