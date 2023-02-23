package cnu.ohd.Member.service;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

        Member member = memberService.create("me", LocalDate.parse("2023-12-01"));

        //when
        long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
        System.out.println(memberRepository.findOne(saveId).getId());
        System.out.println(memberRepository.findOne(saveId).getUuidId());
        System.out.println(memberRepository.findOne(saveId).getTitle());
        System.out.println(memberRepository.findOne(saveId).getDDay());
        System.out.println(memberRepository.findOne(saveId).getCreatedAt());
    }

    @Test
    public void UUID조회() throws Exception {

        Member member1 = memberService.create("me", LocalDate.parse("2023-12-01"));
        UUID testUUID1 = member1.getUuidId();

        int saveId1 = memberService.join(member1);

        Member member2 = memberService.create("me2", LocalDate.parse("2023-12-01"));
        UUID testUUID2 = member2.getUuidId();

        int saveId2 = memberService.join(member2);

        assertEquals(member1, memberRepository.findByUuid(testUUID1));
        assertEquals(member2, memberRepository.findByUuid(testUUID2));
        System.out.println("유저 아이디: "+saveId1);
        System.out.println("유저 아이디: "+saveId2);

    }

    @Test
    public void UUID확인() throws Exception {
        Member test = memberRepository.findByUuid(UUID.fromString("c174480a-2cc5-4a99-8030-009c20b2c38f"));

        assertEquals(test.getUuidId(),UUID.fromString("c174480a-2cc5-4a99-8030-009c20b2c38f"));
        System.out.println(test.getUuidId());

    }



}