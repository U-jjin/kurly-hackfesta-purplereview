package com.kurly.kurlyproject.controller;


import com.kurly.kurlyproject.controller.dto.ReviewForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    //필요 서비스 생성
    @PostMapping("/{itemId}/createReview")
    public String review (@PathVariable("itemId") Long itemId, Model model ){
        //해당 itemId의 카테고리별 질문 리스트를 가져와서 모델에 넣어서 보내주기.
        model.addAttribute("itemId", itemId);
        return "items/{itemId}/reviewForm";
    }

    @PostMapping("items/{itemId}/reviewForm")
    public String create(ReviewForm form){
        //생성자로  객체만들어서 디비에 저장
        return "items/review";
    }

    //리뷰 조회
    //해당 item을 누르면 해당 리뷰들을 볼 수 있도록
    //리뷰스 페이지가 생성될 떄, 아이템 리스트를 보내기




}
