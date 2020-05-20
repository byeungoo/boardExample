package com.board.example.service;

import com.board.example.commons.Criteria;
import com.board.example.dto.BoardDto;

import java.util.List;

public interface IBoardService {

    public void insertBoard (BoardDto board);

    public void updateBoard(BoardDto boardDto);

    public void deleteBoard(BoardDto boardDto);

    public BoardDto getBoard(BoardDto boardDto);

    public List<BoardDto> getBoardList(Criteria criteria);

    public void increaseView(BoardDto boardDto);

    public void insertMassTestBoard(BoardDto boardDto);

    public int getBoardTotalCnt();
}
