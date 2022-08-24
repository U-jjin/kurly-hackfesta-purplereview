package com.kurly.kurlyproject.dto.rateDTO;
import lombok.Getter;
import java.util.ArrayList;



/*
별점, 배달 만족도 월별 평균 데이터를 담기 위한 객체

 */

@Getter
public class RatioListDTO {

    private String totalAvg;
    private ArrayList<String> monthSet;
    private ArrayList<String> monthAvgList;

    public RatioListDTO(String totalAvg, ArrayList<String> monthSet, ArrayList<String> monthAvgList) {
        this.totalAvg = totalAvg;
        this.monthSet = monthSet;
        this.monthAvgList = monthAvgList;
    }
}
