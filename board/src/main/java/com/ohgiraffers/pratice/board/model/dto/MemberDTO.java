package com.ohgiraffers.pratice.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 관련 DTO")
public class MemberDTO {

    @Schema(description = "회원 정보(pk)")
    private int memberCode;

    @Schema(description = "회원 이름")
    private String memberName;
    
    @Schema(description = "회원 아이디")
    private String memberId;
    
    @Schema(description = "회원 비밀번호")
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
