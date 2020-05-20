package com.board.example.service;

import com.board.example.commons.Criteria;
import com.board.example.dao.BoardDao;
import com.board.example.dao.IBoardDao;
import com.board.example.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService implements IBoardService{

    private final IBoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public void insertBoard (BoardDto board) throws RuntimeException{
        boardDao.insertBoard(board);
        //throw new RuntimeException();
    }

    public void updateBoard(BoardDto boardDto) throws RuntimeException{
        boardDao.updateBoard(boardDto);
    }

    public void deleteBoard(BoardDto boardDto) throws RuntimeException{
        boardDao.deleteBoard(boardDto);
    }

    public BoardDto getBoard(BoardDto boardDto) throws RuntimeException{
        BoardDto result = boardDao.getBoard(boardDto);
        return result;
    }

    public List<BoardDto> getBoardList(Criteria criteria) throws  RuntimeException{
        List<BoardDto> resultList = boardDao.getBoardList(criteria);
        return resultList;
    }

    public void increaseView(BoardDto boardDto){
        boardDao.increaseView(boardDto);
    }

    public void insertMassTestBoard(BoardDto boardDto){

        String title = boardDto.getTitle();

        for(int i=0; i<=999;i++){
            boardDto.setTitle(title+i);
            this.insertBoard(boardDto);
        }

        throw new RuntimeException();
    }

    public int getBoardTotalCnt(){
        return boardDao.getBoardTotalCnt();
    }

}
