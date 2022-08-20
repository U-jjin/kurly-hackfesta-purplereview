package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.dto.ItemDTO;
import com.kurly.kurlyproject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem (Item item){
        itemRepository.save(item);
    }
    public List<Item> findItems(){
        return itemRepository.findAll();
    }
    public Item findOne (Long itemId){
        return itemRepository.findOne(itemId);
    }
}
