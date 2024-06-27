package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dto.BoardDTO;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.dto.ResponseMessage;
import com.ohgiraffers.pratice.board.model.service.BoardService;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BoardController {

    private final BoardService service;

    private final MemberService memberService;

    @Autowired
    public BoardController(BoardService service,MemberService memberService) {
        this.service = service;
        this.memberService = memberService;
    }

    /* 전체 조회 */
    @GetMapping("/board")
    public ResponseEntity<ResponseMessage> list() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        List<BoardDTO> boardList = service.findBoard();
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("boardList",boardList);

        return ResponseEntity.ok()
                .headers(headers)
                .body(new ResponseMessage(200,"조회성공",responseMap));

    }

//    @GetMapping("/regist")
//    public void registPage(){}

    /* 등록 */
    @PostMapping("/board")
    public ResponseEntity<?> registBoard(@RequestBody Map<String,Object> newBoard){

        MemberDTO memberCode = memberService.findMemberCode(newBoard.get("memberName").toString());


        service.registBoard(memberCode,newBoard.get("boardTitle").toString(),newBoard.get("boardContent").toString());


        return ResponseEntity.ok().build();
    }

    /* 상세보기 */
    @GetMapping("/board/{boardCode}")
    public ResponseEntity<ResponseMessage> boardDetail(@PathVariable int boardCode){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        BoardDTO board = service.findByboardCode(boardCode);

        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("board",board);

        return ResponseEntity.ok().headers(headers)
                .body(new ResponseMessage(200,"조회 성공",responseMap));

    }

//    @GetMapping("/delete")
//    public String deleteBoard(@RequestParam int boardCode){
//
//        System.out.println("boardCode = " + boardCode);
//        service.deleteBoard(boardCode);
//
//        return "redirect:/board/list";
//    }

//    @GetMapping("/modify")
//    public String modifyBoardPage(@RequestParam int boardCode, Model model){
//
//        BoardDTO board = service.findByboardCode(boardCode);
//
//        model.addAttribute("board", board);
//
//        return "/board/modify";
//    }

    /* 수정 */
    @PutMapping("/board/{boardCode}")
    public ResponseEntity<?> modifyBoard(@PathVariable int boardCode, @RequestBody BoardDTO modifyBoard){

        service.modifyBoard(boardCode,modifyBoard.getBoardTitle(),modifyBoard.getBoardContent());

        return ResponseEntity.created(URI.create("/board/"+boardCode)).build();
    }




}
