package com.ohgiraffers.pratice.board.model.dao;

import com.ohgiraffers.pratice.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT * FROM tbl_member WHERE member_name = :memberName",nativeQuery = true)
    Member findMemberCode(@Param("memberName")String memberName);

}
