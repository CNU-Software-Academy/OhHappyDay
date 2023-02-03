package cnu.ohd.Member.repository;

import cnu.ohd.Member.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    // 단건 조회 (PK 기준으로 찾는 거라 이걸 쓰면 안될 것 같음)
    public Member findOne(int id){
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL 작성 (SQL이랑 차이 있음 : 엔티티 객체를 대상으로 조회를 함)
                .getResultList();
    }

    // user_id로 단건 조회
    public Member findByUserId(int userId){
        return em.find(Member.class, userId);
    }

    // uuid로 단건 조회
    public Member findByUuid(UUID uuidId){
        return em.createQuery("select m from Member m where m.uuidId = :uuidId", Member.class)
                .setParameter("uuidId", uuidId)
                .getSingleResult();
    }


}
