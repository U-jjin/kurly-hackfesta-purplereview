package com.kurly.kurlyproject.dto;


import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.category.Category;
import com.kurly.kurlyproject.domain.category.CategoryItem;
import com.kurly.kurlyproject.domain.review.KeywordReview;
import com.kurly.kurlyproject.domain.review.Question;
import com.kurly.kurlyproject.domain.review.Review;
import com.kurly.kurlyproject.dto.reviewDto.ReviewDto;
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
        List<String> categoryNameList = new ArrayList<>();

        List<QuestionDTO> quesDtoList =new ArrayList<>();

        for(CategoryItem c : item.getCategoryItemList()){
            Category parent = c.getCategory();
            categoryNameList.add(parent.getName());

            for(Question q: parent.getQuestionList()){
                quesDtoList.add(convertToDto(q));
            }

            while(parent.getParent() != null){
                parent = parent.getParent();
                categoryNameList.add(parent.getName());

                for(Question q: parent.getQuestionList()){
                    quesDtoList.add(convertToDto(q));
                }
            }
        }
        Collections.reverse(categoryNameList);
        Collections.reverse(quesDtoList);
        return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getDiscountPrice(), item.getImageUrl(), categoryNameList, quesDtoList);
    }

    /*
     QuestionDTO 변환
     */
    public static QuestionDTO convertToDto(Question question){
        return new QuestionDTO(question.getId(), question.getAsking(), question.getAnswers().split("&"));
    }

    /*
        KeyWordReviewDTO 변환
        리스트 변환 1
     */
    public static List<KeywordReviewDTO> convertToKeyReviewDtoList(List<KeywordReview> keyReviewList){
            List<KeywordReviewDTO> dtoList = new ArrayList<>();

        for(KeywordReview keyreview: keyReviewList ) {
                dtoList.add(new KeywordReviewDTO(keyreview.getQuestion().getId(),keyreview.getQuestion().getAsking(),keyreview.getAnswer()));
        }
        return dtoList;
    }

    public KeywordReviewDTO convertToDto(KeywordReview keyReview){
        return new KeywordReviewDTO(keyReview.getQuestion().getId(),keyReview.getQuestion().getAsking(), keyReview.getAnswer());
    }
    
    public static ReviewDto convertToDto(Review review){
        List<KeywordReviewDTO> keywordReviewList = convertToKeyReviewDtoList(review.getKeywordReviewList());

        return new ReviewDto(review.getId(),review.getDate(),review.getMember().getName(),review.getItemContent(),review.getStar(),keywordReviewList);
    }

}
