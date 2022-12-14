package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.DtoConvertor;
import com.kurly.kurlyproject.dto.rateDTO.RatioListDTO;
import com.kurly.kurlyproject.dto.reviewDto.ReviewDto;
import com.kurly.kurlyproject.dto.rateDTO.ReviewRatioDTO;
import com.kurly.kurlyproject.dto.reviewDto.ReviewVO;
import com.kurly.kurlyproject.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final KeywordReviewRepository keywordReviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private  final QuestionRepository questionRepository;


    //리뷰 생성 메소드
    @Transactional
    public Long save(ReviewVO reviewVo, Long itemId){
        Item item = itemRepository.findOne(itemId);
        Member member =memberRepository.findOne(reviewVo.getMemberId());

        //키워드 리뷰 엔티티
        List<KeywordReview> keyList =new ArrayList<>();

        for(Map<String,String> r: reviewVo.getKeywordReviews()){
            if(r.get("answer") ==null ) continue;  //키워드 리뷰를 입력하지 않았으면 제외.
            keyList.add(KeywordReview.createKeywordReview(questionRepository.findOne(Long.valueOf(r.get("questionId"))), r.get("answer")));
        }

        //리뷰 엔티티 생성
        Review review= Review.createReview(item, member,reviewVo.getItemContent(), reviewVo.getDeliveryContent(),
                reviewVo.getStar(), reviewVo.getDeliverySatisfaction(),keyList);

        reviewRepository.save(review);

        return review.getId();
    }

    //리뷰 리스트 조회
    public List<ReviewDto> findReviewsByItem(Long itemId){

        List<ReviewDto> reviewDtoList =new ArrayList<>();

        for(Review r: reviewRepository.findByItemId(itemId)){
            reviewDtoList.add(DtoConvertor.convertToDto(r));
        }

        return reviewDtoList;
    }

    // 키워드 질문에 대한 비율 조회
    public List<ReviewRatioDTO> findkeywordRateList (Long itemId){
        int sum = 0;
        ArrayList<String> askingList =new ArrayList<>();
        ArrayList<ArrayList<String>> answerlists =new ArrayList<>();
        ArrayList<ArrayList<Double>> ratiolists =new ArrayList<>();

        //레포지토리에서 입력받아 온 값을 데이터 형식에 맞게 변환
        for(Object[] object: keywordReviewRepository.findKeywordReview(itemId)){

            String asking= object[0].toString()+"&"+object[1].toString()+"&"+object[2].toString();
            String answer = object[3].toString();
            double count =Double.parseDouble(object[4].toString());
            sum +=count;

            if(!askingList.contains(asking)){
                askingList.add(asking);
                answerlists.add(new ArrayList<>());
                ratiolists.add(new ArrayList<>());
            }
            int idx = askingList.indexOf(asking);

            answerlists.get(idx).add(answer);
            ratiolists.get(idx).add(count);
        }

        List<ReviewRatioDTO> dtoList =new ArrayList<>();

        for(int i=0; i<askingList.size(); i++){
            dtoList.add(new ReviewRatioDTO(askingList.get(i),answerlists.get(i),ratiolists.get(i),sum/2));
        }

        Collections.sort(dtoList);
        return dtoList;
    }

    public RatioListDTO findStarData(Long itemId){

        //별점 만족도 total, 월별 평균 구하기
        //total
        String itemAvg = String.format("%.1f",reviewRepository.findStarTotalAvgByItem(itemId));

        //monthly
        ArrayList<String> itemMonthlyAvgList =new ArrayList<>();
        ArrayList<String> monthList =new ArrayList<>();

        for(Object[] object : reviewRepository.findStarMonthlyAvgByItem(itemId)){
            monthList.add(object[0].toString());
            itemMonthlyAvgList.add(String.format("%.2f",Double.parseDouble(object[1].toString())));
        }

        return new RatioListDTO(itemAvg,monthList,itemMonthlyAvgList);


    }


    public  RatioListDTO findDeliveryData(Long itemId){

        //배달 만족도 total, 월별 평균 구하기
        Map<String, List<Object[]>> delimap = reviewRepository.findDeliByItem(itemId);

        List<Object[]> goodlist =delimap.get("good");
        List<Object[]> badlist =delimap.get("bad");

        ArrayList<String> monthList =new ArrayList<>();
        ArrayList<Double> ratioGoodList =new ArrayList<>();
        ArrayList<Double> ratioBadList = new ArrayList<>();

        double delisum =0;
        double goodsum = 0;

        for(Object[] object: goodlist){
            monthList.add(object[0].toString());
            double monthlycnt =Double.parseDouble(object[1].toString());
            delisum += monthlycnt;
            goodsum += monthlycnt;
            ratioGoodList.add(monthlycnt);
        }

        for(Object[] object: badlist){
            double monthlycnt =Double.parseDouble(object[1].toString());
            delisum += monthlycnt;
            ratioBadList.add(monthlycnt);
        }

        //배달 total 평균 만족도
        String totalDeliAvg = String.format("%.1f",goodsum/delisum*100);

        //배달 월별 만족도
        ArrayList<String> deliMonthlyAvgList =new ArrayList<>();

        for(int i=0; i<ratioGoodList.size(); i++){
            deliMonthlyAvgList.add(String.format("%.2f", ratioGoodList.get(i)/(ratioGoodList.get(i)+ratioBadList.get(i))*100));
        }
        return new RatioListDTO(totalDeliAvg,monthList,deliMonthlyAvgList);


    }

}
