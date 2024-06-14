package com.ohgiraffers.pratice.board.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_code")
    private int memberCode;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;



    protected Member(){}

    public Member( String memberName, String memberId, String memberPwd) {

        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                '}';
    }
}
