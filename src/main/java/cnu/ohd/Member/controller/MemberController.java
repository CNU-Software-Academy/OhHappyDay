package cnu.ohd.Member.controller;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String saveMember(Member member) {
        // service단으로 보내는 코드 작성 필요

        return "redirect:./";
    }




}
