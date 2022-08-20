package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.*;
@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;


    public void save(Review review){
        em.persist(review);
    }

    public List<Review> findItemReview(Long itemId){
     //아이템 리뷰 값 가져오기.
     return em.createQuery("select r from Review r where r.item.id = :itemId",Review.class).getResultList();
    }
}
