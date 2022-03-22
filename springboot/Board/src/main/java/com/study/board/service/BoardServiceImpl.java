package com.study.board.service;

import com.study.board.domain.BoardDTO;
import com.study.board.mapper.BoardMapper;
import com.study.board.paging.Criteria;
import com.study.board.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override //게시글 등록 & 수정 메서드
    public boolean registerBoard(BoardDTO params) {
        //메서드 실행 결과 저장 --> 호출한 쿼리가 정상적으로 실행되면 쿼리를 실행한 횟수, 즉 1이 저장됨
        int queryResult = 0;
        //게시글 번호(idx)의 유무 기준으로 INSERT 또는 UPDATE를 실행
        if(params.getIdx() == null) {
            queryResult = boardMapper.insertBoard(params);
        }else{
            queryResult = boardMapper.updateBoard(params);
        }


        return (queryResult==1)?true:false;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
        //TODO 게시글 조회 수 증가 로직
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;
        //idx로 db를 조회해서
        BoardDTO board = boardMapper.selectBoardDetail(idx);
        //특정 게시글을 조회하고, 사용 중인 상태의 게시글인 경우에만 게시글을 삭제함
        if(board != null && "N".equals(board.getDeleteYn())){
            int deleteIdx = boardMapper.deleteBoard(idx);
            System.out.println("삭제 return idx?:"+deleteIdx);
            queryResult = deleteIdx;
        }
        //쿼리 실행 결과를 true 또는 false로 반환
        return (queryResult == 1)?true: false;
        
    }

    @Override //삭제되지 않은 전체 게시글을 조회
    public List<BoardDTO> getBoardList(BoardDTO params) {
        //Collections.emptyList() --> https://dololak.tistory.com/48
        List<BoardDTO> boardList = Collections.emptyList(); //NPE방지를 위해 Collection.emptyList메서드를 이용해 빈 리스트를 선언

        int boardTotalCount = boardMapper.selectBoardTotalCount(params); //삭제되지 않은, 즉 사용 중인 전체 게시글 수를 카운팅 한 결과를 저장
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(boardTotalCount);

        params.setPaginationInfo(paginationInfo);

        //사용 중인 전체 게시글이 1개 이상이면
        if(boardTotalCount > 0){
            boardList = boardMapper.selectBoardList(params);
        }
        return boardList;

    }
}
