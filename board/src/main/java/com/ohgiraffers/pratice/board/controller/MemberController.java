package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dto.BoardDTO;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.dto.ResponseMessage;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Member 기능)")
@RestController
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    /* 전체 유저 조회 */
    @Operation(summary = "전체 유저 조회",description = "우리 사이트의 전체 유저 목록 조회")
    @GetMapping("/member")
    public ResponseEntity<ResponseMessage> list() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        List<MemberDTO> MemberList = service.findall();
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("MemberList",MemberList);

        return ResponseEntity.ok()
                .headers(headers)
                .body(new ResponseMessage(200,"조회성공",responseMap));

    }

    @Operation(summary = "신규 회원 등록")
    @PostMapping("/member")
    public ResponseEntity<?> regist(@RequestBody MemberDTO newMember) {

        service.memberRegist(newMember);

        return ResponseEntity.ok().build();
    }




}
