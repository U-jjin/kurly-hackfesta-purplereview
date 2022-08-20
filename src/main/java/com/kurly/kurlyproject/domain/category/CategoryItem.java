package com.kurly.kurlyproject.domain.category;

import com.kurly.kurlyproject.domain.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
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


    /*
        연관관계 메소드
     */
    private void addCategory(Category category){
        this.category =category;
        category.getCategoryItemList().add(this);
    }
    private void addItem(Item item){
        this.item = item;
        item.getCategoryItemList().add(this);
    }



}
