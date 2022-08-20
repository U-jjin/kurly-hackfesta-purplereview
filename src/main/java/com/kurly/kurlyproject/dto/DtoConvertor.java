package com.kurly.kurlyproject.dto;


import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Question;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.ItemDTO;
import com.kurly.kurlyproject.dto.KeywordReviewDTO;
import com.kurly.kurlyproject.dto.QuestionDTO;
import com.kurly.kurlyproject.dto.ReviewDTO;
import com.kurly.kurlyproject.repository.CategoryItemRepository;
import com.kurly.kurlyproject.repository.KeywordReviewRepository;
import com.kurly.kurlyproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DtoConvertor {

    final private QuestionRepository questionRepository;
    final private KeywordReviewRepository keywordReviewRepository;

    /*
        ItemDTO 변환
     */
    public static ItemDTO convertToDto(Item item){
        List<String> categories = new ArrayList<>();

        for(CategoryItem c : item.getCategoryItemList()){
            categories.add(c.getCategory().getName());
        }

        return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getDiscountPrice(), item.getImageUrl(), categories);
    }

    /*
     QuestionDTO 변환
     */
    public QuestionDTO convertToDto(Question question){
        return new QuestionDTO(question.getId(), question.getAsking(), question.getAnswers().split("&"));
    }

    /*
        KeyWordReviewDTO 변환
     */
    public KeywordReviewDTO convertToDto(KeywordReview keyReview){
        return new KeywordReviewDTO( questionRepository.findOne(keyReview.getQuestion().getId()).getAsking(), keyReview.getAnswer());
    }
    
//    public ReviewDTO convertToDto(Review review){
//        List<KeywordReviewDTO> keywordReviews = new ArrayList<>();
//
//        for(KeywordReview kr  :keywordReviewRepository.findKeywordReview(review.getId())){
//            keywordReviews.add(convertToDto(kr));
//        }
//
//        return new ReviewDTO(review.getId(), review.getDate(),
//                review.getMember().getId(), review.getItem().getId(),
//                review.getItemContent(), review.getStar(), review.getDeliverySatisfaction(),
//                keywordReviews);
//    }

}
