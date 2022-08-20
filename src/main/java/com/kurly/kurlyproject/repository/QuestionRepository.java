package com.kurly.kurlyproject.repository;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.review.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    private final EntityManager em;

    public void save(Question question){
        em.persist(question);
    }

    public Question findOne(Long id){
        return em.find(Question.class,id);
    }

    public List<Question> findAll(){
        return em.createQuery("select q from Question q",Question.class).getResultList();
    }


}
