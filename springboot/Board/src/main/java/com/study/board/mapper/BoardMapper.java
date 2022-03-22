package com.study.board.mapper;

import com.study.board.domain.BoardDTO;
import com.study.board.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int insertBoard(BoardDTO params);  //게시글 생성   결과값이 리턴 타입으로 지정된 BoardDTO클래스의 멤버 변수에 매핑. 게시글 정보가 넘어옴

    public BoardDTO selectBoardDetail(Long idx); //특정 게시글 조회

    public int updateBoard(BoardDTO params); //수정  파라미터로는 BoardDTO 클래스가 params라는 이름으로 지정. 게시글 정보가 넘어옴

    public int deleteBoard(Long idx); //삭제 상태값 바꾸기만

    public List<BoardDTO> selectBoardList(BoardDTO params); //전체 게시글 조회  BoardDTO타입의 파라미터를 받는다

    public int selectBoardTotalCount(BoardDTO params); //삭제 여부(delete_yn)가 'N'으로 지정된 게시글의 개수를 조회(사용 중인 전체 게시글 수 카운트). 페이징 처리시 사용
}
