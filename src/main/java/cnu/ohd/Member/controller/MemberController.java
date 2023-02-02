package cnu.ohd.Member.controller;

import cnu.ohd.Member.MemberVo;
import cnu.ohd.Member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void saveMember(){

    }

    @PostMapping("/singin")
    @ResponseBody
    public MemberVo testSingIn(){

        MemberVo user = new MemberVo();
        user.setUuidId(UUID.randomUUID());
        user.setTitle("내방");
        user.setDDay(LocalDate.parse("2023-12-31"));
        user.setCreatedAt(LocalDate.now());

        return user;

    }
}
