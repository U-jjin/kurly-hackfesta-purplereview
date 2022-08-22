package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.DtoConvertor;
import com.kurly.kurlyproject.dto.reviewDto.GetGraphDataDTO;
import com.kurly.kurlyproject.dto.reviewDto.ReviewDto;
import com.kurly.kurlyproject.dto.reviewDto.ReviewRatioDTO;
import com.kurly.kurlyproject.dto.reviewDto.ReviewVO;
import com.kurly.kurlyproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final KeywordReviewRepository keywordReviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private  final QuestionRepository questionRepository;

    @Transactional
    public Long save(ReviewVO reviewVo, Long itemId){
        Item item = itemRepository.findOne(itemId);
        Member member =memberRepository.findOne(reviewVo.getMemberId());
        List<KeywordReview> keyList =new ArrayList<>();

        for(Map<String,String> r: reviewVo.getKeywordReviews()){
            keyList.add(KeywordReview.createKeywordReview(questionRepository.findOne(Long.valueOf(r.get("questionId"))), r.get("answer")));
        }
        Review review= Review.createReview(item, member,reviewVo.getItemContent(), reviewVo.getDeliveryContent(),
                reviewVo.getStar(), reviewVo.getDeliverySatisfaction(),keyList);

        reviewRepository.save(review);

        return review.getId();
    }

    public List<ReviewDto> findReviewsByItem(Long itemId){

        List<ReviewDto> reviewDtoList =new ArrayList<>();

        for(Review r: reviewRepository.findByItemId(itemId)){
            reviewDtoList.add(DtoConvertor.convertToDto(r));
        }

        return reviewDtoList;
    }

    public List<ReviewRatioDTO> answerRate (Long itemId){
        Double sum =0.0;
        ArrayList<String> askingList =new ArrayList<>();
        ArrayList<ArrayList<String>> answerlists =new ArrayList<>();
        ArrayList<ArrayList<Double>> ratiolists =new ArrayList<>();

        for(Object[] object: keywordReviewRepository.findKeywordReview(itemId)){

            String asking= object[0].toString()+"&"+object[1].toString();
            String answer = object[2].toString();
            Double count =Double.parseDouble(object[3].toString());
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
            dtoList.add(new ReviewRatioDTO(askingList.get(i),answerlists.get(i),ratiolists.get(i),sum));
        }

        return dtoList;
    }

    public void findGraphData(Long itemId){


        //별점 만족도 total, 월별 평균 구하기
        //total
        Double itemAvg = reviewRepository.findStarTotalAvgByItem(itemId);

        //monthly
        double [] itemMonthlyAvgList =new double[12];

        for(Object[] object : reviewRepository.findStarMonthlyAvgByItem(itemId)){
            int idx = Integer.parseInt(object[0].toString())-1;
            itemMonthlyAvgList[idx] = Double.parseDouble(object[1].toString());
        }

        //배달 만족도 total, 월별 평균 구하기
        Map<String, List<Object[]>> delimap = reviewRepository.findDeliByItem(itemId);

        List<Object[]> goodlist =delimap.get("good");
        List<Object[]> badlist =delimap.get("bad");
        int [] monthlyGoods = new int[12];
        int [] monthlyBads = new int[12];
        for(Object[] object: goodlist){
            int idx = Integer.parseInt(object[0].toString())-1;
            monthlyGoods[idx] = Integer.parseInt(object[1].toString());
        }
        for(Object[] object: badlist){
            int idx = Integer.parseInt(object[0].toString())-1;
            monthlyBads[idx] = Integer.parseInt(object[1].toString());
        }

        int delisum =0;
        int goodsum = 0;

        //배달 월별 만족도
        double[] deliveryMonthlyAvgList =new double[12];

        for(int i=0; i<12; i++){
            int sum =  monthlyGoods[i]+monthlyBads[i];
            delisum += sum;
            goodsum +=monthlyGoods[i];
            deliveryMonthlyAvgList[i] = (double)monthlyGoods[i]/sum*100;
        }
        //배달 total 만족도
        double deliveryAvg = (double)goodsum/(double)delisum*100;


        //키워드 데이터 구하기 이거능
        List<ReviewRatioDTO> reviewRatioDTOS = answerRate(itemId);


        GetGraphDataDTO graphDto = new GetGraphDataDTO(itemAvg, deliveryAvg,itemMonthlyAvgList,deliveryMonthlyAvgList,reviewRatioDTOS);

    }

}
