package com.kurly.kurlyproject.dto;

import com.kurly.kurlyproject.domain.Item;
import lombok.Getter;

import java.util.*;
@Getter
public class ItemDTO {
    private Long itemId;
    private String name;
    private int price;
    private int discountPrice;
    private String imgURL;
    private List<String> categories;
    private List<QuestionDTO> questionList;

    public ItemDTO(Long id, String name, int price, int discountPrice, String imgURL, List<String> categories, List<QuestionDTO> questionList) {
        this.itemId = id;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.imgURL = imgURL;
        this.categories = categories;
        this.questionList = questionList;
    }

}
