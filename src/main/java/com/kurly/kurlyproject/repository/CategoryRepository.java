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

    public Category findOne(Long Id){
        return em.find(Category.class, Id);
    }


    //우선 보류 저 리스트가 어떻게 나오는지 확인 후에 ㅇㅅㅇ 쿼리DSL 적용하자
    public List<Category> findCategpries(Long itemId){

        return em.createQuery("select c from Category c " +
                                    "where c.id = (select ci.category.id " +
                                                "from CategoryItem ci " +
                                                "where ci.item=:itemId)"
                                    ,Category.class).getResultList();
    }
}
