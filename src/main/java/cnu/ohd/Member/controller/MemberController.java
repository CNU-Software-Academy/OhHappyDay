package cnu.ohd.Member.controller;

import cnu.ohd.Member.MemberDto;
import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.service.MemberService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 방 생성 (회원가입)
    @PostMapping("/api/signup")
    @ResponseBody
    public UUID saveMember(@RequestBody MemberDto form){

        log.info("SignIn info -> Title : {}, dDay : {}",form.getTitle(),form.getDDay());

        Member member = memberService.create(form.getTitle(), form.getDDay());
        memberService.join(member);

        return member.getUuidId();

    }

}
