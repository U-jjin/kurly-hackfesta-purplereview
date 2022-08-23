package com.kurly.kurlyproject.service;


import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import com.kurly.kurlyproject.repository.CategoryItemRepository;
import com.kurly.kurlyproject.repository.CategoryRepository;
import com.kurly.kurlyproject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryItemRepository categoryItemRepository;
    private final ItemRepository itemRepository;


    public Category findOne(Long categoryId){
        return  categoryRepository.findOne(categoryId);
    }


}
