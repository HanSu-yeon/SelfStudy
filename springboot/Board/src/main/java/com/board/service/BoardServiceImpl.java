package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service// 비즈니스 로직을 담당하는 서비스 클래스임을 의미
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired //@Autowired를 이용해서 BoardMapper 인터페이스 빈(Bean)을 주입
    private BoardMapper boardMapper;

    @Override  //게시글 번호(idx)의 유무를 기준으로 insert또는 update를 실행
    public boolean registerBoard(BoardDTO params) {
        int queryResult = 0; //호출한 쿼리가 정상 실행되면 1(쿼리실행횟수)이 저장된다
        if (params.getIdx() == null) {
            queryResult = boardMapper.insertBoard(params);
        } else {
            queryResult = boardMapper.updateBoard(params);
        }
        return (queryResult == 1) ? true : false; //쿼리 실행 결과를 기준으로 true 또는 false반환
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx); //하나의 게시글 조회 메소드. 화면 처리가 마무리되면 게시글의 조회 수를 증가시키는 로직이 추가될 예정
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;
        BoardDTO board = boardMapper.selectBoardDetail(idx);
        if (board != null && "N".equals(board.getDeleteYn())) {
            queryResult = boardMapper.deleteBoard(idx);
        }
        return (queryResult == 1) ? true : false;

    }

    @Override //삭제되지 않은 전체 게시글을 조회
    public List<BoardDTO> getBoardList() {
        //비어있는 리스트를 선언
        List<BoardDTO> boardList = Collections.emptyList(); //Collections.emptyList():비어있는 리스트를 만들 때 쓰인다.
        //삭제되지 않은, 즉 사용 중인 전체 게시글 수 카운팅 한 결과 저장
        int boardTotalCount = boardMapper.selectBoardTotalCount();

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList();
        }
        return boardList;
    }


}
