package com.kurly.kurlyproject.repository;

import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class KeywordReviewRepository {

    private final EntityManager em;

    public void save(KeywordReview review){
        em.persist(review);
    }

    //천천히 생각
    public List<Long> findKeywordReview(Long itemId){
        //작성된 리뷰에 대한 키워드 리뷰 카운트 값 가져오기.
        return em.createQuery("select count(kr) from KeywordReview kr where kr.review.item.id=:itemId group by kr.answer",Long.class).setParameter("itemId",itemId).getResultList();
    }
}
