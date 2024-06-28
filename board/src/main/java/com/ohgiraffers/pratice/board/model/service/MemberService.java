package com.ohgiraffers.pratice.board.model.service;

import com.ohgiraffers.pratice.board.entity.Member;
import com.ohgiraffers.pratice.board.model.dao.MemberRepository;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final ModelMapper modelMapper;
    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Transactional
    public void memberRegist(MemberDTO newMember) {

        Member member = new Member(
                newMember.getMemberName(),
                newMember.getMemberId(),
                newMember.getMemberPwd()
        );

        repository.save(member);

    }

    public MemberDTO findMemberCode(String memberName) {

        Member memberCode = repository.findMemberCode(memberName);

        System.out.println("memberCode = " + memberCode);

        return modelMapper.map(memberCode, MemberDTO.class);
    }

    public List<MemberDTO> findall() {

        List<Member> members = repository.findAll();

        return modelMapper.map(members, List.class);
    }
}
