package com.board.example.service;

import com.board.example.dao.BoardDao;
import com.board.example.dto.BoardDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    BoardDao boardDao;

    @Autowired
    BoardService boardService;

    //게시글 생성 테스트
    @Test
    public void insertBoardTest(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        boardService.insertBoard(boardDto);
    }

    //게시글 조회 테스트
    @Test
    public void getBoardTest(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        boardService.insertBoard(boardDto);
        BoardDto savedBoardDto= boardService.getBoard(boardDto);
        Assertions.assertEquals(boardDto.getTitle(), savedBoardDto.getTitle());
        Assertions.assertEquals(boardDto.getContent(), savedBoardDto.getContent());
        Assertions.assertEquals(boardDto.getWriter(), savedBoardDto.getWriter());
    }

    //게시글 업데이트 테스트
    @Test
    public void updateBoardTest(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        boardService.insertBoard(boardDto);

        boardDto.setTitle("제목 업데이트");
        boardDto.setContent("내용 업데이트");
        boardService.updateBoard(boardDto);

        BoardDto updatedBoardDto = boardService.getBoard(boardDto);
        Assertions.assertEquals(boardDto.getTitle(), updatedBoardDto.getTitle());
        Assertions.assertEquals(boardDto.getContent(), updatedBoardDto.getContent());
    }

    //게시글 삭제 테스트
    @Test
    public void deleteBoardTest(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        boardDao.insertBoard(boardDto);
        boardService.deleteBoard(boardDto);
        BoardDto updatedBoardDto = boardDao.getBoard(boardDto);
        Assertions.assertEquals(null, updatedBoardDto);
    }

}
