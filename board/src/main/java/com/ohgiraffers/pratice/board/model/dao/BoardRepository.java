package com.ohgiraffers.pratice.board.model.dao;

import com.ohgiraffers.pratice.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {


    Board findByboardCode(int boardCode);


    void deleteByboardCode(int boardCode);
}
