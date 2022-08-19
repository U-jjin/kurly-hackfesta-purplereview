package com.kurly.kurlyproject.domain.category;

import com.kurly.kurlyproject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name="category_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;



    //카테고리별 아이템 리턴 로직 구현

    //

}
