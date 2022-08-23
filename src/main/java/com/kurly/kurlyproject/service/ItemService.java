package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.dto.DtoConvertor;
import com.kurly.kurlyproject.dto.ItemDTO;
import com.kurly.kurlyproject.dto.QuestionDTO;
import com.kurly.kurlyproject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDTO> findItems(){
        List<ItemDTO> itemList = new ArrayList<>();

        for(Item item:itemRepository.findAll()){
            itemList.add(DtoConvertor.convertToDto(item));
        }

        return itemList;
    }
    public ItemDTO findOne (Long itemId){
        return DtoConvertor.convertToDto(itemRepository.findOne(itemId));
    }


}
