package com.kurly.kurlyproject.controller;


import com.kurly.kurlyproject.dto.ItemDTO;
import com.kurly.kurlyproject.dto.rateDTO.ReviewRatioDTO;
import com.kurly.kurlyproject.service.ItemService;
import com.kurly.kurlyproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ReviewService reviewService;



    @GetMapping("/orderlist")
    @ResponseBody
    public Map<String,List<ItemDTO>> itemlist(){
        Map<String, List<ItemDTO>> map =new HashMap<>();
        map.put("itemlist",itemService.findItems());
        return map;
    }


    @GetMapping("/items/{itemId}")
    @ResponseBody
    public List<ReviewRatioDTO> itemReviewList(@PathVariable("itemId") Long itemId){

        //리뷰 조회는 보류
//        Map<String, Object> map = new HashMap<>();
//        map.put("reviewList",reviewService.findReviewsByItem(itemId));

        return reviewService.answerRate(itemId);
    }


}


