package com.kurly.kurlyproject.domain.item;

import com.kurly.kurlyproject.domain.category.CategoryItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    //상속 관계 맵핑
    private String name;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

//    @ManyToMany(mappedBy = "items")
//    private List<Category> categories =new ArrayList<>();

    /*
        비즈니스 로직
        - setter 를 가지고 재고 수량 컨트롤 하는 것이 아니라.
        - 엔티티 안에서 필요한 메소드를 만드는 것이 응집력을 높이는 객체지향형 코드.
        1. 재고 수량 증가 로직
        2. 감소 로직
     */







}