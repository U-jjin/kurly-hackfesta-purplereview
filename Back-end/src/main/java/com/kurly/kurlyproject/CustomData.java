package com.kurly.kurlyproject;

import java.time.LocalDateTime;
import java.util.Random;


public class CustomData {

    //랜던 가상 리뷰 날짜 생성을 위한 메소드
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
}
