package com.kurly.kurlyproject.repository;

import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager em;

    public void save(Category category){
        em.persist(category);
    }

    public Category findOne(Long Id){return em.find(Category.class, Id);
    }
}
