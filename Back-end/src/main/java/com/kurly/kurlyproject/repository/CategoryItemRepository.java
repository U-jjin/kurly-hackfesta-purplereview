package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryItemRepository {
    private final EntityManager em;

    public void save(CategoryItem item){
        em.persist(item);
    }
    public CategoryItem findOne(Long Id){
        return em.find(CategoryItem.class, Id);
    }
}
