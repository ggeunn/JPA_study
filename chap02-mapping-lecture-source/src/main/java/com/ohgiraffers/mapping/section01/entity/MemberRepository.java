package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    /* 참고. Entity 매니저를 주입받아 영속성 컨텍스트레 우리가 만든 Entity를 관리할 수 있도록 한다. (이것도 직접적으로 사용은 안 할 것임) */
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {

        entityManager.persist(member);

    }

    public String findNameById(String memberId) {

        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" +memberId +"'";

        return entityManager.createQuery(jpql, String.class).getSingleResult();
    }
}
