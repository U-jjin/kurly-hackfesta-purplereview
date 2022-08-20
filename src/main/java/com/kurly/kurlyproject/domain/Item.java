package com.kurly.kurlyproject.domain;

import com.kurly.kurlyproject.domain.category.CategoryItem;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int discountPrice;
    private String imageUrl;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    @OneToMany(mappedBy="item")
    private List<Review> reviewList =new ArrayList<>();

    public Item(String name, int price, int discountPrice, String imageUrl) {
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.imageUrl = imageUrl;
    }


    /*
        연관 관계 메소드
     */

    /*
        비즈니스 로직
        - setter 를 가지고 재고 수량 컨트롤 하는 것이 아니라.
        - 엔티티 안에서 필요한 메소드를 만드는 것이 응집력을 높이는 객체지향형 코드.
        1. 재고 수량 증가 로직
        2. 감소 로직
     */
}