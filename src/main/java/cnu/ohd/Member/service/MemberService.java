package cnu.ohd.Member.service;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public int join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public Member create(String title, LocalDate dDay){
        Member member = new Member();
        member.setUuidId(UUID.randomUUID());
        member.setTitle(title);
        member.setDDay(dDay);
        member.setUuidId(UUID.randomUUID());

        return member;
    }

    // 회원 전체 조회
//    public List<Member> findMembers(){
//        return memberRepository.findAll();
//    }

    // 회원 단건 조회
//    public Member findOne(int memberId){
//        return memberRepository.findOne(memberId);
//    }

    // uuid 단건 조회
    public Member findByUuid(UUID uuid) {
        return memberRepository.findByUuid(uuid);
    }


}
