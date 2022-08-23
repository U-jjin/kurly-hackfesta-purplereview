package com.kurly.kurlyproject.dto.rateDTO;

import antlr.collections.List;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

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
