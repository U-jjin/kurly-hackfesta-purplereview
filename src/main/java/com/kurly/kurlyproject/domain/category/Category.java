package com.kurly.kurlyproject.domain.category;

import com.kurly.kurlyproject.domain.review.Question;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @OneToMany(mappedBy="category")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Question> questionList =new ArrayList<>();

    public Category(String name, Long depth, Category parent) {
        this.name = name;
        this.depth = depth;
        this.parent =parent;
        parent.addChildCategory(this);
    }

    public Category() {

    }

    //연관관계 메소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
}