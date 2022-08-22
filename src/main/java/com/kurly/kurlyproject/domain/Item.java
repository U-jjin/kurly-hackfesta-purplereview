package com.kurly.kurlyproject.domain;

import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL)
    private List<Review> reviewList =new ArrayList<>();

    public Item(String name, int price, int discountPrice, String imageUrl) {
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.imageUrl = imageUrl;
    }



    public Item() {

    }

    //질문 리스트 반환
}