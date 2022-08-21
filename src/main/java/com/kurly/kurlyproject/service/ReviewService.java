package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import com.kurly.kurlyproject.domain.review.DeliverySatisfaction;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.DtoConvertor;
import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import com.kurly.kurlyproject.dto.reviewDto.GetReviewDto;
import com.kurly.kurlyproject.dto.reviewDto.PostReviewDto;
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

    public void save(PostReviewDto dto, Long itemId){
        Item item = itemRepository.findOne(itemId);
        Member member =memberRepository.findOne(dto.getMemberId());

        List<KeywordReview> keywordReviewList =new ArrayList<>();
        for(KeywordReviewDTO keyword: dto.getKeywordReviews()){
            keywordReviewList.add(KeywordReview.createKeywordReview(questionRepository.findOne(keyword.getQuestionId()), keyword.getAnswer()));
        }

        Review review =Review.createReview(member,item,dto.getItemContent(), dto.getDeliveryContent(),
                                    dto.getStar(), dto.getDeliverySatisfaction(), keywordReviewList);

        reviewRepository.save(review);
    }


    public List<GetReviewDto> findReviewsByItem(Long itemId){

        List<GetReviewDto> reviewDtoList =new ArrayList<>();

        for(Review r: reviewRepository.findByItemId(itemId)){
            reviewDtoList.add(DtoConvertor.convertToDto(r));
        }

        return reviewDtoList;
    }


    //리뷰 데이터 생성시에 추가 구현
    public List<Long> answerRate (Long itemId){
        return keywordReviewRepository.findKeywordReview(itemId);
    }

}
