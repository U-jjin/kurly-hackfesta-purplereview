package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.*;

import static com.kurly.kurlyproject.domain.review.DeliverySatisfaction.Bad;
import static com.kurly.kurlyproject.domain.review.DeliverySatisfaction.Good;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;
    public void save(Review review){
        em.persist(review);
    }

    public List<Review> findByItemId(Long itemId){
     return em.createQuery(" select r from Review r where r.item.id=:itemId order by r.date desc ",Review.class).setParameter("itemId",itemId).getResultList();
    }

    //평균 별점 조회
    public Double findStarTotalAvgByItem(Long itemId){
       return em.createQuery("select avg(r.star) from Review r where r.item.id=:itemId", Double.class).setParameter("itemId", itemId).getSingleResult();
    }

    //별점의 월별 비율을 구하기 위해 데이터 조회
    public List<Object[]> findStarMonthlyAvgByItem(Long itemId){
       return em.createQuery("select substring(r.date,1,7) as d, avg(r.star)" +
                        "from Review r " +
                        "where r.item.id=:itemId " +
                        "group by d", Object[].class)
                .setParameter("itemId",itemId).getResultList();

    }

    //배달 만족도에 대한 비율을 구하기 위해 데이터 조회
    public Map<String, List<Object[]>> findDeliByItem(Long itemId){
        List goodlist = em.createQuery("select substring(r.date,1,7) as d, count(r.deliverySatisfaction)" +
                                                    " from Review r where r.deliverySatisfaction=:sati " +
                                                    "group by d",Object[].class)
                                                    .setParameter("sati", Good).getResultList();

        List badlist = em.createQuery("select substring(r.date,1,7) as d, count(r.deliverySatisfaction)" +
                                                        " from Review r where r.deliverySatisfaction=:sati " +
                                                        "group by d",Object[].class)
                                                        .setParameter("sati", Bad).getResultList();
        Map<String, List<Object[]>> map =new HashMap<>();
        map.put("good",goodlist);
        map.put("bad",badlist);

        return  map;
    }


}
