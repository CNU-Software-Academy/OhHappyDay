package cnu.ohd.Member.service;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    public void 회원가입() throws Exception {
        //given

        Member member = memberService.create("me", "1234", "내방", LocalDate.parse("2023-12-01"));

        //when
        int saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
        System.out.println(memberRepository.findOne(saveId).getId());
        System.out.println(memberRepository.findOne(saveId).getCreatedAt());
        System.out.println(memberRepository.findOne(saveId).getUserId());
    }

    @Test
    public void UUID조회() throws Exception {

        Member member = memberService.create("me", "1234", "내방", LocalDate.parse("2023-12-01"));
        UUID testUUID = member.getUuidId();

        int saveId = memberService.join(member);

        assertEquals(member, memberRepository.findByUuid(testUUID));

    }



}