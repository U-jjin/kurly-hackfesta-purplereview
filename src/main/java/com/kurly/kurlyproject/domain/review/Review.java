package com.kurly.kurlyproject.domain.review;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue
    @Column(name="review_id")
    private Long id;
    private LocalDateTime date;

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

    public void addKeywordReview(KeywordReview keywordReview){
        this.keywordReviewList.add(keywordReview);
        keywordReview.addReview(this);
    }


    public static Review createReview (Item item, Member member, String itemContent, String deliveryContent, int star, String satisfaction, List<KeywordReview> keywordReviewList) {
            Review review =new Review();

            review.addMember(member);
            review.addItem(item);
            review.setDate(LocalDateTime.now());
            review.setItemContent(itemContent);
            review.setDeliveryContent(deliveryContent);
            review.setStar(star);
            review.setDeliverySatisfaction(DeliverySatisfaction.valueOf(satisfaction));


            for(KeywordReview keyreview : keywordReviewList) {
                review.addKeywordReview(keyreview);
            }
            return review;
    }
}
