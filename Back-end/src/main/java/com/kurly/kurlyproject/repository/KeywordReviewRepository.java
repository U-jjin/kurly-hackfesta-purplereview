package com.kurly.kurlyproject.repository;

import com.kurly.kurlyproject.domain.review.KeywordReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;


@Repository
@RequiredArgsConstructor
public class KeywordReviewRepository {

    private final EntityManager em;

    public void save(KeywordReview review){
        em.persist(review);
    }


    public List<Object[]> findKeywordReview(Long itemId){

        return em.createQuery("select " +
                "kr.question.category.name,kr.question.category.depth, kr.question.asking, kr.answer, count(kr.answer)" +
                " from KeywordReview kr " +
                "where kr.review.item.id=:itemId " +
                "group by kr.answer", Object[].class)
                .setParameter("itemId",itemId).getResultList();

    }

}
