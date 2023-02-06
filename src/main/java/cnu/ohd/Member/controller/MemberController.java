package cnu.ohd.Member.controller;

import cnu.ohd.Member.MemberDto;
import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/api/signup")
    @ResponseBody
    public UUID saveMember(@RequestBody MemberDto form){

        log.info("SignIn info -> UserId : {}, Pw : {}, Title : {}, dDay : {}",form.getUserId(),form.getPw(),form.getTitle(),form.getDDay());

        Member member = memberService.create(form.getUserId(), form.getPw(), form.getTitle(), form.getDDay());
//        memberService.join(member);

        return member.getUuidId();

    }

    // 로그인 테스트용
    // 원래는 UUID만 반환해주기
    @PostMapping("/api/signin")
    @ResponseBody
    public Member testSignIn(@RequestBody MemberDto form){

        log.info("SignIn info -> UserId : {}, PW : {}",form.getUserId(),form.getPw());

        Member user = memberService.create("me","1234","내방",LocalDate.parse("2023-12-31"));
        user.setCreatedAt(LocalDate.now());

        return user;
    }
}
