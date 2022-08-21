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

    public List<Review> findByItemId(Long itemId){
     return em.createQuery(" select r from Review r where r.item.id=:itemId ",Review.class).setParameter("itemId",itemId).getResultList();
    }
}
