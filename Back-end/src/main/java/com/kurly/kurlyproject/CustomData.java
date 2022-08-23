package com.kurly.kurlyproject;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class CustomData {

    public static LocalDateTime createRandomDate(){
        int [] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        Random random =new Random();
        int month = random.nextInt(12)+1;
        int day = random.nextInt(maxDays[month-1]-1)+1;
        int year;
        if(month>=9) year =2021;
        else year= 2022;

        return LocalDateTime.of(year,month,day,00,00,00);
    }

//    public static List<String[]> reorderMonth(String[] arr){
//        int nowMonth = LocalDateTime.now().getMonth().getValue();
//
//        String [] ratearr =new String[12];
//        String [] montharr =new String[12];
//
//        List<String> rateList =new ArrayList<>();
//        List<String> monthlList = new ArrayList<>();
//
//
//
//
//
//    }
}
