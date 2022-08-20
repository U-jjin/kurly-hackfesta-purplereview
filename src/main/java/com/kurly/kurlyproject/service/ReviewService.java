package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.ReviewDTO;
import com.kurly.kurlyproject.repository.ItemRepository;
import com.kurly.kurlyproject.repository.KeywordReviewRepository;
import com.kurly.kurlyproject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final KeywordReviewRepository keywordReviewRepository;
    private final ItemRepository itemRepository;

//   보류
//    @Transactional
//    public Long write(){}



    //find




}
