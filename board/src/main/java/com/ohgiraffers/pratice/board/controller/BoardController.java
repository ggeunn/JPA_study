package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dto.BoardDTO;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.dto.ResponseMessage;
import com.ohgiraffers.pratice.board.model.service.BoardService;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import java.util.stream.Collectors;

@Tag(name = "Board 기능)")
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
    @Operation(summary = "전체 게시글 조회",description = "우리 사이트의 전체 게시글 목록 조회")
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



    /* 등록 */
    @Operation(summary = "신규 게시글 등록")
    @PostMapping("/board")
    public ResponseEntity<?> registBoard(@RequestBody Map<String,Object> newBoard){

        MemberDTO memberCode = memberService.findMemberCode(newBoard.get("memberName").toString());


        service.registBoard(memberCode,newBoard.get("boardTitle").toString(),newBoard.get("boardContent").toString());


        return ResponseEntity.ok().build();
    }

    /* 상세보기 */
    @Operation(summary = "게시글 번호로 게시글 조회", description = "게시글 번호를 통해 해당되는 게시글을 조회한다."
            , parameters = {@Parameter(name = "boardCode",description = "사용자 화면에서 넘어오는 board 의 pk")} )
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


    @Operation(summary = "게식글 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 된 파라미터")
    })
    @DeleteMapping("/board/{boardCode}")
    public ResponseEntity<?> remodveBoard(@PathVariable int boardCode){

        BoardDTO board = service.findByboardCode(boardCode);
        service.remove(board);

        return ResponseEntity.noContent().build();

    }


    /* 수정 */
    @Operation(summary = "게시글 수정")
    @PutMapping("/board/{boardCode}")
    public ResponseEntity<?> modifyBoard(@PathVariable int boardCode, @RequestBody BoardDTO modifyBoard){

        service.modifyBoard(boardCode,modifyBoard.getBoardTitle(),modifyBoard.getBoardContent());

        return ResponseEntity.created(URI.create("/board/"+boardCode)).build();
    }




}
