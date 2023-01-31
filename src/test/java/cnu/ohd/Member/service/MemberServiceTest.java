package cnu.ohd.Member.service;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        UUID uuid = UUID.randomUUID();
        Member member = new Member();
        member.setUserId("bye");
        member.setPw("byebye1234");
        member.setRoom("안녕잘가");
        member.setDDay(LocalDate.parse("2023-12-01"));
        member.setUuidId(uuid);

        //when
        int saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));


    }



}