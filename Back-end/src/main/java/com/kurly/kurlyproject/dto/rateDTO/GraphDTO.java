package com.kurly.kurlyproject.dto.rateDTO;

import lombok.Getter;

import java.util.*;
@Getter
public class GraphDTO {
    private String itemScoreAvg;
    private String deliveryScoreAvg;
    private Map<String,List<String>> graphData;

    private ArrayList<String> monthDataList;
    private List<ReviewRatioDTO> keywordData;


    public GraphDTO(String itemScoreAvg, String deliveryScoreAvg,ArrayList<String> monthDataList, ArrayList<String>itemMonthlys, ArrayList<String>deliMonthlys, List<ReviewRatioDTO> keywordData) {
        this.itemScoreAvg = itemScoreAvg;
        this.deliveryScoreAvg = deliveryScoreAvg;
        this.monthDataList = monthDataList;
        graphData = new HashMap<>();
        graphData.put("item",itemMonthlys);
        graphData.put("delivery",deliMonthlys);

        this.keywordData = keywordData;
    }
}
