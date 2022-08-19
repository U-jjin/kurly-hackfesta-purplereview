package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.item.Item;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;


    public void save(Review review){
        //저장 로직 짜기
    }

    public void findItemReview(Long itemId){
     //아이템 리뷰 값 가져오기  + 상세리뷰도 같이
    }

    public void findItemKeywordReview(Long reviewId){

    }





}
