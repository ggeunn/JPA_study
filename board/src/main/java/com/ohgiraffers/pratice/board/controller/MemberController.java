package com.ohgiraffers.pratice.board.controller;

import com.ohgiraffers.pratice.board.model.dao.MemberRepository;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import com.ohgiraffers.pratice.board.model.service.MemberService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String regist(MemberDTO newMember) {

        service.memberRegist(newMember);

        return "main/main";
    }




}
