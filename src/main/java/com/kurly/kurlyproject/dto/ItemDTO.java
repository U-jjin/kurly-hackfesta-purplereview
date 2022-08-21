package com.kurly.kurlyproject.dto;

import com.kurly.kurlyproject.domain.Item;
import lombok.Getter;

import java.util.*;
@Getter
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int discountPrice;
    private String imgURL;
    private List<String> categories;
    private List<QuestionDTO> questionList; //빼기

    public ItemDTO(Long id, String name, int price, int discountPrice, String imgURL, List<String> categories, List<QuestionDTO> questionList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.imgURL = imgURL;
        this.categories = categories;
        this.questionList = questionList;
    }
}
