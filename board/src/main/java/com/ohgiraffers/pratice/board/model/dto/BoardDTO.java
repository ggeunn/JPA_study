package com.ohgiraffers.pratice.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Board 관련 DTO")
public class BoardDTO {

    @Schema(description = "게시글정보(PK)")
    private int boardCode;
    
    @Schema(description = "게시글 제목")
    private String boardTitle;
    
    @Schema(description = "게시물 내용")
    private String boardContent;
    
    @Schema(description = "회원정보")
    private MemberDTO member;

    public BoardDTO() {}

    public BoardDTO(int boardCode, String boardTitle, String boardContent, MemberDTO member) {
        this.boardCode = boardCode;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.member = member;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boardCode=" + boardCode +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", member=" + member +
                '}';
    }
}
