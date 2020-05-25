package com.board.example.dao;

import com.board.example.dto.BoardDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class BoardDaoTest {

    @Autowired
    BoardDao boardDao;

    public BoardDto createBoardDto(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        return boardDto;
    }

    //게시글 생성 테스트
    @Test
    public void insertBoardTest(){
        BoardDto boardDto = createBoardDto();
        boardDao.insertBoard(boardDto);
    }


    //게시글 업데이트 테스트
    @Test
    public void updateBoardTest(){
        BoardDto boardDto = createBoardDto();
        boardDao.insertBoard(boardDto);

        boardDto.setTitle("제목업데이트");
        boardDto.setContent("내용업데이트");
        boardDao.updateBoard(boardDto);

        BoardDto savedBoardDto = boardDao.getBoard(boardDto);

        Assertions.assertEquals("제목업데이트", savedBoardDto.getTitle());
        Assertions.assertEquals("내용업데이트", savedBoardDto.getContent());
    }

}