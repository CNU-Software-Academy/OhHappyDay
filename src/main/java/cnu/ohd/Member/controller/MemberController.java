package cnu.ohd.Member.controller;

import cnu.ohd.Member.MemberDto;
import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import cnu.ohd.Member.service.MemberService;
import cnu.ohd.gift.domain.Gift;
import cnu.ohd.gift.service.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final GiftService giftService;

    // 방 생성 (회원가입)
    @PostMapping("/api/signup")
    @ResponseBody
    public UUID saveMember(@RequestBody MemberDto form){

//        log.info("SignUp info -> Title : {}, dDay : {}",form.getTitle(),form.getDDay());

        Member member = memberService.create(form.getTitle(), form.getDDay());
        memberService.join(member);

        return member.getUuidId();
    }

    @GetMapping("/api/rooms/{uuidId}")
    @ResponseBody
    public ResponseEntity <Map<String,Object>> roomInfo(@PathVariable("uuidId") UUID uuidId) {
        long userId = memberRepository.findUserId(uuidId);

        Map<String,Object> map = new HashMap<>();

        map.put("memberInfo",memberService.findOne(userId));
        map.put("giftList",giftService.findByMemberId(userId));

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
