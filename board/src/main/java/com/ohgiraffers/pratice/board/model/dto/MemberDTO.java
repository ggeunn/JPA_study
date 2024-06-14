package com.ohgiraffers.pratice.board.model.dto;

public class MemberDTO {

    private int memberCode;
    private String memberName;
    private String memberId;
    private String memberPwd;

    public MemberDTO() {}

    public MemberDTO( String memberName, String memberId, String memberPwd) {

        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                '}';
    }
}
