package com.study.board.service;

import com.study.board.domain.BoardDTO;
import com.study.board.paging.Criteria;

import java.util.List;

public interface BoardService {

    public boolean registerBoard(BoardDTO params);

    public BoardDTO getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<BoardDTO> getBoardList(BoardDTO params);
}
