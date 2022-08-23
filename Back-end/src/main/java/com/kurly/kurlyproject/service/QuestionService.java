package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.review.Question;
import com.kurly.kurlyproject.dto.QuestionDTO;
import com.kurly.kurlyproject.repository.CategoryRepository;
import com.kurly.kurlyproject.repository.ItemRepository;
import com.kurly.kurlyproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveItem (Question question){
        questionRepository.save(question);
    }

}
