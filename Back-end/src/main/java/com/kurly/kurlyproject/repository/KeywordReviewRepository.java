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


    //질문별 총합 갯수 구하기
    public void findSumOfQustion(Long itemId){

        em.createQuery("select kr.question.asking, sum(count(kr)) from KeywordReview kr where kr.review.item.id=:itemId group by kr.question", Map.class).setParameter("itemId",itemId).getResultList();
    }



    public List<Object[]> findKeywordReview(Long itemId){

        return em.createQuery("select " +
                "kr.question.category.name, kr.question.asking, kr.answer, count(kr.answer)" +
                " from KeywordReview kr " +
                "where kr.review.item.id=:itemId " +
                "group by kr.answer",
                Object[].class).setParameter("itemId",itemId).getResultList();

    }

}
