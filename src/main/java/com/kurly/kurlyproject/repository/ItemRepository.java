package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;
    public void save(Item item){
        em.persist(item);
    }
    public Item findOne(Long id){ return em.find(Item.class,id); }

    public List<Item>findAll(){
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }





//    public List<ReviewDTO> findReviewList (Long itemId){
//        List<ReviewDTO> reviewList =new ArrayList<>();
//        for(Review r: em.find(Item.class, itemId).getReviewList()){
//            reviewList.add(DtoConvertor.convertToDto(r));
//        }
//        return reviewList;
//    }

    public void findRate(Long itemId){
        List<KeywordReview> keyReviewList =new ArrayList<>();
        for(Review r: em.find(Item.class, itemId).getReviewList()){
            keyReviewList.addAll(r.getKeywordReviewList());
        }


    }



}
