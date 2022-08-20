package com.kurly.kurlyproject.repository;


import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.dto.ItemDTO;
import lombok.NoArgsConstructor;
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

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item>findAll(){
        return  em.createQuery("select i from Item i",Item.class).getResultList();
    }


//    public ItemDTO findOne(Long id){
//        return  DtoConvertor.convertToDto(em.find(Item.class, id));
//    }
//
//    public List<ItemDTO>findAll(){
//        List<ItemDTO> itemDTOS =new ArrayList<>();
//        for(Item item: em.createQuery("select i from Item i",Item.class).getResultList()){
//            itemDTOS.add(DtoConvertor.convertToDto(item));
//        }
//        return itemDTOS;
//    }


}
