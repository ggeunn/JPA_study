package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/* 필기.
*   클래스 선언부 위에 위치해서 JPA에서 사용되는 엔티티 클래스임을 표시한다.
*   이는 해당 클래스와 데이터베이스의 테이블 매핑을 의미한다.
*   - 기본 생성자는 필수로 작성해야 한다.
*   - final 클래스, enum, interface, inner class 에서는 사용할 수 없다.
*   - 저장할 필드에 final 을 사용하면 안된다.
*  */
@Entity(name = "entityMember")
@Table(name = "tbl_member")
public class Member {

    /* 필기.
    *   @Column 속성
    *   - name : 매핑할 테이블의 컬럼 이름
    *   - nullable : null 값 허용여부 설정 = NOTNULL 제약 조건에 해당한다. default(true)
    *   - unique : 컬럼의 유일성을 제약 조건
    *   - columnDefinition : 직접 컬럼의 DDL 을 지정할 수 있다.
    *   - length : 문자열의 길이 = String 타입에서만 사용 default(255)
    * */

    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 자동 번호 부여
    private int memberNo;

    @Column(name = "member_id",nullable = false, unique = true , columnDefinition = "varchar(10)")
    private String memberId;

    @Column(name = "member_pwd" , nullable = false)
    private String memberPwd;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address" , length = 900)
    private String address;

    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;

    // enum 타입 쓸 떄 - 딱 정해진 값 ex) 권한, 성별등등
    @Column(name = "member_role")
    private MemberRole  memberRole;

}
