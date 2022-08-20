package com.kurly.kurlyproject.domain.review;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue
    @Column(name="review_id")
    private Long id;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @Lob
    private String itemContent;

    @Lob
    private String deliveryContent;

    private int star;

    @Enumerated(EnumType.STRING)
    private DeliverySatisfaction deliverySatisfaction; // good, bad

    @OneToMany(mappedBy = "review",  cascade = CascadeType.ALL)
    private List<KeywordReview> keywordReviewList =new ArrayList<>();

    /*
        연관관계 메소드
     */

    public void addItem(Item item){
        this.item =item;
        item.getReviewList().add(this);
    }

    public void addMember(Member member){
        this.member =member;
        member.getReviewList().add(this);
    }

}
