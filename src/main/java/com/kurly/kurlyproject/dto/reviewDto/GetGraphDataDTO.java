package com.kurly.kurlyproject.dto.reviewDto;

import java.util.*;

public class GetGraphDataDTO {
    private double itemScoreAvg;
    private double deliveryScoreAvg;
    private Map<String,double[]> graphData;
    private List<ReviewRatioDTO> keywordData;


    public GetGraphDataDTO(double itemScoreAvg, double deliveryScoreAvg, double[]itemMonthlys, double[]deliMonthlys, List<ReviewRatioDTO> keywordData) {
        this.itemScoreAvg = itemScoreAvg;
        this.deliveryScoreAvg = deliveryScoreAvg;

        graphData = new HashMap<>();
        graphData.put("item",itemMonthlys);
        graphData.put("delivery",deliMonthlys);

        this.keywordData = keywordData;
    }
}
