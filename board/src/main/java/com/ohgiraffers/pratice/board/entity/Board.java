package com.ohgiraffers.pratice.board.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tbl_board")
@Builder(toBuilder = true)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_code")
    private int boardCode;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_content")
    private String boardContent;

    @ManyToOne
    @JoinColumn(name = "member_code" )
    private Member member;

    protected Board(){}

    public Board(Member member,String boardTitle, String boardContent ) {
        this.member = member;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    public Board(int boardCode, String boardTitle, String boardContent,Member member ) {
        this.boardCode = boardCode;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.member = member;
    }
    public int getBoardCode() {
        return boardCode;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardCode=" + boardCode +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", member=" + member +
                '}';
    }
}
