package com.kurly.kurlyproject.controller;


import com.kurly.kurlyproject.dto.rateDTO.GraphDTO;
import com.kurly.kurlyproject.dto.rateDTO.RatioListDTO;
import com.kurly.kurlyproject.dto.rateDTO.ReviewRatioDTO;
import com.kurly.kurlyproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.TreeSet;

@CrossOrigin("*")
@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final ReviewService reviewService;

    @GetMapping("/graphdata/{itemId}")
    @ResponseBody
    public GraphDTO graph(@PathVariable("itemId")Long itemId){

        RatioListDTO starData = reviewService.findStarData(itemId);
        RatioListDTO deliveryData = reviewService.findDeliveryData(itemId);

        List<ReviewRatioDTO> reviewRatioDTOS =reviewService.findkeywordRateList(itemId);

        return new GraphDTO(starData.getTotalAvg(),deliveryData.getTotalAvg(),starData.getMonthSet(),starData.getMonthAvgList(),deliveryData.getMonthAvgList(),reviewRatioDTOS);
    }
}

