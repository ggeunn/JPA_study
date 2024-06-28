package com.ohgiraffers.pratice.board.model.service;

import com.ohgiraffers.pratice.board.entity.Board;
import com.ohgiraffers.pratice.board.entity.Member;
import com.ohgiraffers.pratice.board.model.dao.BoardRepository;
import com.ohgiraffers.pratice.board.model.dto.BoardDTO;
import com.ohgiraffers.pratice.board.model.dto.MemberDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardService(BoardRepository repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public List<BoardDTO> findBoard() {

        List<Board> boardList = repository.findAll();

        return boardList.stream()
                .map(board -> modelMapper.map(board,BoardDTO.class))
                .collect(Collectors.toList());

    }

    @Transactional
    public void registBoard(MemberDTO memberCode, String boardTitle, String boardContent) {


        Board board = new Board(modelMapper.map(memberCode, Member.class),boardTitle,boardContent);

        repository.save(board);

    }


    public BoardDTO findByboardCode(int boardCode) {

        Board board = repository.findByboardCode(boardCode);

        return modelMapper.map(board,BoardDTO.class);
    }



    @Transactional
    public void modifyBoard(int boardCode, String boardTitle, String boardContent) {

        Board board = repository.findByboardCode(boardCode);

        board = board.toBuilder().boardTitle(boardTitle).boardContent(boardContent).build();

        repository.save(board);

    }

    @Transactional
    public void remove(BoardDTO board) {
        Board boardEntity = repository.findByboardCode(board.getBoardCode());
        repository.delete(boardEntity);

    }
}
