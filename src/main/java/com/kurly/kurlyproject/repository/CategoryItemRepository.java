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

    //아이템별 카테고리아이템 리스트 가져오기
    public List findItemCategory(Long itemId){
        return em.createQuery("select ci.category" +
                                    " from CategoryItem ci " +
                                    "where ci.item.id =:itemId"
                                    , Category.class).getResultList();
    }


}
