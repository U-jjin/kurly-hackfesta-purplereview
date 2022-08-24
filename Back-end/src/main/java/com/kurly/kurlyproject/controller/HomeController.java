package com.kurly.kurlyproject.controller;

import com.kurly.kurlyproject.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")

@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final ItemService itemService;
    private final MemberService memberService;
    private final ReviewService reviewService;
    private final CategoryService categoryService;
    private final QuestionService questionService;

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "/home";
    }
}
