package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/* 예약어인지 잘 보기 */
@Entity
@Table(name = "tbl_like")
public class Like {

    /* 우리가 세트로 묶어 둔 memberNo, bookNo 를 ID(pk)로서 사용 */
    @EmbeddedId
    private LikedCompositeKey compositeKey;

    protected Like() {}

    public Like(LikedCompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

}
