package com.kurly.kurlyproject.service;

import com.kurly.kurlyproject.domain.Item;
import com.kurly.kurlyproject.domain.member.Member;
import com.kurly.kurlyproject.repository.ItemRepository;
import com.kurly.kurlyproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember (Member member){
        memberRepository.save(member);
    }
    public Member findMember(Long memberId){
        return memberRepository.findOne(memberId);

    }
}
