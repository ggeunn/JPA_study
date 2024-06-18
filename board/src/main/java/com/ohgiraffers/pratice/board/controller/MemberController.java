package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dao.MemberRepository;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/member")
    public ResponseEntity<?> regist(@RequestBody MemberDTO newMember) {

        service.memberRegist(newMember);

        return ResponseEntity.ok().build();
    }




}
