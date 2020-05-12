package com.board.example.service;

import com.board.example.dao.BoardDao;
import com.board.example.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public void insertBoard (BoardDto board){
        boardDao.insertBoard(board);
    }

}
