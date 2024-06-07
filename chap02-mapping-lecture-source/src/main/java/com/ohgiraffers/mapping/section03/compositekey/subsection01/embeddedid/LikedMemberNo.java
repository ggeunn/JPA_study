package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LikedMemberNo {

    @Column(name = "like_member_no")
    private int likeMemberNo;

    protected LikedMemberNo() {}

    public LikedMemberNo(int likeMemberNo) {
        this.likeMemberNo = likeMemberNo;
    }
}
