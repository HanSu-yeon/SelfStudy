package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;

//서비스(Business Layer) 처리하기
//게시글CRUD와 리스트 처리하는 메소드들
public interface BoardService {
    public boolean registerBoard(BoardDTO params);

    public BoardDTO getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<BoardDTO> getBoardList();
}
