package com.board.example.service;

import com.board.example.dao.BoardDao;
import com.board.example.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    @Transactional
    public Map<String, Object> insertBoard (BoardDto board) throws Exception{

        Map<String, Object> result = new HashMap<>();

        boardDao.insertBoard(board);

        /*
        board.setId(14L);
        BoardDto test = boardDao.getBoard(board);
        test.getContent();
        */

        result.put("resltMsg", "게시글이 등록되었습니다.");
        result.put("resultCode", "success");

        return result;
    }

}
