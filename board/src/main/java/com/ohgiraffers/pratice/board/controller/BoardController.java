package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dto.BoardDTO;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.service.BoardService;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    private final MemberService memberService;

    @Autowired
    public BoardController(BoardService service,MemberService memberService) {
        this.service = service;
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public void list(Model model) {

        List<BoardDTO> boardList = service.findBoard();

        System.out.println("boardList = " + boardList);

        model.addAttribute("boardList", boardList);

    }

    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public String registBoard(@RequestParam String memberName, @RequestParam String boardTitle, @RequestParam String boardContent){

        System.out.println("memberName = " + memberName);
        System.out.println("boardTitle = " + boardTitle);
        System.out.println("boardContent = " + boardContent);
        MemberDTO memberCode = memberService.findMemberCode(memberName);

        System.out.println("memberCode = " + memberCode);

        service.registBoard(memberCode,boardTitle,boardContent);

        return "redirect:/board/list";
    }

    @GetMapping("/boarddetail")
    public void boardDetail(@RequestParam int boardCode, Model model){

        BoardDTO board = service.findByboardCode(boardCode);

        model.addAttribute("board", board);

    }
    @GetMapping("/delete")
    public String deleteBoard(@RequestParam int boardCode){

        System.out.println("boardCode = " + boardCode);
        service.deleteBoard(boardCode);

        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String modifyBoardPage(@RequestParam int boardCode, Model model){

        BoardDTO board = service.findByboardCode(boardCode);

        model.addAttribute("board", board);

        return "/board/modify";
    }

    @PostMapping("/modify")
    public String modifyBoard(@RequestParam int boardCode, @RequestParam String boardTitle, @RequestParam String boardContent){

        service.modifyBoard(boardCode,boardTitle,boardContent);


        return "redirect:/board/boarddetail?boardCode="+boardCode;
    }




}
