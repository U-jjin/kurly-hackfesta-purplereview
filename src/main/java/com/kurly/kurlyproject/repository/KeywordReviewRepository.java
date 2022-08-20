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

    public void save(Review review){
        em.persist(review);
    }

    public List<KeywordReview> findKeywordReview(Long reviewId){
        //잗성된 리뷰에 대한 키워드 리뷰값 가져오기.
        return em.createQuery("select kr from KeywordReview kr where kr.review.id = :reviewId",KeywordReview.class).getResultList();
    }
}
