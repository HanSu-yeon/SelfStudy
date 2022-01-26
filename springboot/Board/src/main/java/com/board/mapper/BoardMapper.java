package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

//Mapper인터페이스: 데이터베이스와 통신 역할
//@Mapper해주면 xml mapper에서 메서드의 이름과 일치하는 sql문을 찾아 실행한다
//Mapper 영역은 데이터베이스와의 통신, 즉 SQL 쿼리를 호출하는 것이 전부
@Mapper
public interface BoardMapper {
    public int insertBoard(BoardDTO params); //params: 게시글 정보

    public BoardDTO selectBoardDetail(Long idx); //결과값이 리턴타입으로 지정된 boardDTO클래스의 멤버 변수에 매핑

    public int updateBoard(BoardDTO params);

    public int deleteBoard(Long idx);

    public List<BoardDTO> selectBoardList(); //BoardDTO타입을 파라미터로 갖음. 메소드 호출 결과를 여러개 저장한다(List)

    public int selectBoardTotalCount(); //페이징 처리
}
