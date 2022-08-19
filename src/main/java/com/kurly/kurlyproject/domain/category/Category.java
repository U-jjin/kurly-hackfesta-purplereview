package com.kurly.kurlyproject.domain.category;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    private String name;

    private Long depth;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    @OneToMany(mappedBy="category")
    private List<CategoryItem> categoryItemList = new ArrayList<>();


    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }


}