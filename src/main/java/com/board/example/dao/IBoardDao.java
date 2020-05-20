package com.board.example.dao;

import com.board.example.commons.Criteria;
import com.board.example.dto.BoardDto;

import java.util.List;

public interface IBoardDao {

    public void insertBoard (BoardDto boardDto);

    public BoardDto getBoard(BoardDto boardDto);

    public void updateBoard(BoardDto boardDto);

    public void deleteBoard(BoardDto boardDto);

    public List<BoardDto> getBoardList(Criteria criteria);

    public int getBoardTotalCnt();

    public void increaseView(BoardDto boardDto);

}
