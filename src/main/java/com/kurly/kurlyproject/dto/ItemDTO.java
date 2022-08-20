package com.kurly.kurlyproject.dto;

import java.util.*;
public class ItemDTO {

    private Long id;
    private String name;
    private int price;
    private int discountPrice;
    private String imgURL;
    private List<String> categories;


    public ItemDTO(Long id, String name, int price, int discountPrice, String imgURL, List<String> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.imgURL = imgURL;
        this.categories = categories;
    }
}
