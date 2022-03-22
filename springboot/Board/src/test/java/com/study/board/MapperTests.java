package com.study.board;

import com.study.board.domain.BoardDTO;
import com.study.board.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
//@WebAppConfiguration
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfInsert(){
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");

        int result = boardMapper.insertBoard(params);
        System.out.println("결과는"+result);
    }
}
