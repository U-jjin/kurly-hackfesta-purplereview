package com.kurly.kurlyproject.domain.member;

import com.kurly.kurlyproject.domain.member.Gender;
import com.kurly.kurlyproject.domain.review.Review;
import lombok.Getter;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String password;
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();


    /*
        연관관계 메소드
     */




}