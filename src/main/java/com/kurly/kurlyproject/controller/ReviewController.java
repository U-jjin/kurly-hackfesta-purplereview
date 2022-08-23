package com.kurly.kurlyproject.controller;


import com.kurly.kurlyproject.dto.rateDTO.RatioListDTO;
import com.kurly.kurlyproject.dto.reviewDto.ReviewVO;
import com.kurly.kurlyproject.repository.ItemRepository;
import com.kurly.kurlyproject.repository.QuestionRepository;
import com.kurly.kurlyproject.service.ItemService;
import com.kurly.kurlyproject.service.QuestionService;
import com.kurly.kurlyproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import  java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review/{itemId}")
    public Long create(@PathVariable("itemId") Long itemId, @RequestBody ReviewVO review){

        return  reviewService.save(review,itemId);
    }


    @PostMapping("/reviews/{itemId}")
    public void createList(@PathVariable("itemId") Long itemId, @RequestBody List<ReviewVO> review){

        for(ReviewVO vo : review){
            reviewService.save(vo,itemId);
        }
    }














}
