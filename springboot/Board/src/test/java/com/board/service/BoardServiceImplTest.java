package com.study.board.service;

import com.study.board.domain.BoardDTO;
import com.study.board.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceImplTest {

    @Autowired
    private BoardMapper boardMapper;


    @Test
    void registerBoard() {
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("1번 게시글 등록자");
        int result = boardMapper.insertBoard(params);
        System.out.println(result);
    }

    @Test
    void getBoardDetail() {
    }

    @Test
    void deleteBoard() {
    }

    @Test
    void getBoardList() {
    }
}