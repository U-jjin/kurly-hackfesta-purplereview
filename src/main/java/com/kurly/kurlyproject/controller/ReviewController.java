package com.kurly.kurlyproject.controller;


import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import com.kurly.kurlyproject.dto.reviewDto.GetReviewDto;
import com.kurly.kurlyproject.dto.reviewDto.PostReviewDto;
import com.kurly.kurlyproject.repository.ItemRepository;
import com.kurly.kurlyproject.repository.QuestionRepository;
import com.kurly.kurlyproject.service.ItemService;
import com.kurly.kurlyproject.service.QuestionService;
import com.kurly.kurlyproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final ReviewService reviewService;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    @PostMapping("/review/{itemId}")
    public void create(@PathVariable("itemId") Long itemId, @RequestBody PostReviewDto review){

        reviewService.save(review,itemId);
    }

//    @GetMapping("/reviews")
//    public void insertTest(){
//
//        KeywordReviewDTO keywordReviewDTO =new KeywordReviewDTO(Long.valueOf())
//
//        PostReviewDto postReviewDto =new PostReviewDto(Long.valueOf(3),"물품이 엄청 좋아요!","배송 잘받았어요.",5,"GOOD")
//
//
//
//
//    }





}
