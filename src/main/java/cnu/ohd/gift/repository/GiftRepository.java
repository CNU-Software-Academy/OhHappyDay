package cnu.ohd.gift.repository;

import cnu.ohd.gift.domain.Gift;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GiftRepository {

    private final EntityManager em;

    public void save(Gift gift){
        em.persist(gift);
    }

    public List<Gift> findAllGifts(long memberId) {
        return em.createQuery("select m from Gift m where m.member.id = :memberId", Gift.class)
                .setParameter("memberId",memberId)
                .getResultList();
    }

    public void changeGift(long giftId) {
        em.createQuery("update Gift m set m.checked = 1 where m.giftId = :giftId")
                .setParameter("giftId",giftId)
                .executeUpdate();
        em.clear();
    }


}
