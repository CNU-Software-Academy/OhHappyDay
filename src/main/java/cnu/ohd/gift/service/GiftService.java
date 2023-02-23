package cnu.ohd.gift.service;

import cnu.ohd.Member.domain.Member;
import cnu.ohd.Member.repository.MemberRepository;
import cnu.ohd.gift.domain.Gift;
import cnu.ohd.gift.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public long join(Gift gift) {
        giftRepository.save(gift);
        return gift.getGiftId();
    }

    public Gift create(UUID memberId,String gTo,String message,String gFrom,char box,char ribbon) {
        Member member = memberRepository.findByUuid(memberId);

        Gift gift = new Gift();
        gift.setMember(member);
        gift.setGTo(gTo);
        gift.setMessage(message);
        gift.setGFrom(gFrom);
        gift.setBoxColor(box);
        gift.setRibbonColor(ribbon);

        return gift;
    }

    public List<Gift> findByMemberId(long memberId) {
        return giftRepository.findAllGifts(memberId);
    }
}
