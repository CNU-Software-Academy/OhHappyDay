package cnu.ohd.Member.controller;

import cnu.ohd.Member.MemberDto;
import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    @ResponseBody
    public void saveMember(){

        // 회원 가입할 객체 만들기 (이걸 따로 메서드를 만들어서 사용해야함)
//        memberService.create()

//        memberService.join();

    }

    // api 통신 test 용 (JSON 객체 만들어서 반환)
    @PostMapping("/api/signin")
    @ResponseBody
    public Member testSignIn(MemberDto form){

        System.out.println(form.toString());

        Member user = new Member();
        user.setUuidId(UUID.randomUUID());
        user.setTitle("내방");
        user.setDDay(LocalDate.parse("2023-12-31"));
        user.setCreatedAt(LocalDate.now());

        return user;
    }
}
