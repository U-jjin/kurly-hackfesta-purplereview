package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.review.DeliverySatisfaction;
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


    public Double findStarTotalAvgByItem(Long itemId){
       return em.createQuery("select avg(r.star) from Review r where r.item.id=:itemId",Long.class).setParameter("itemId",itemId).getSingleResult().doubleValue();
    }

    public List<Object[]> findStarMonthlyAvgByItem(Long itemId){
       return em.createQuery("select month(r.date), avg(r.star)" +
                        "from Review r " +
                        "where r.item.id=:itemId " +
                        "group by month(r.date)", Object[].class)
                .setParameter("itemId",itemId).getResultList();

    }

    public Map<String, List<Object[]>> findDeliByItem(Long itemId){
        List<Object[]> goodlist = em.createQuery("select month(r.date), count(r.deliverySatisfaction) from Review r where r.deliverySatisfaction=:sati group by month(r.date)").setParameter("sati", Good).getResultList();
        List<Object[]> badlist = em.createQuery("select  month(r.date), count(r.deliverySatisfaction) from Review r where r.deliverySatisfaction=:sati group by month(r.date)").setParameter("sati", Bad).getResultList();

        Map<String, List<Object[]>> map =new HashMap<>();
        map.put("good",goodlist);
        map.put("bad",badlist);

        return  map;

    }


}
