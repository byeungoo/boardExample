package com.board.example.commons;

import com.board.example.dto.BoardDto;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PageMakerTest {

    static List<BoardDto> boardDtoList = new ArrayList<>();

    public static BoardDto createBoardDto(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        return boardDto;
    }

    @BeforeAll
    public static void setup(){
        for(int i=1;i<150;i++){
            BoardDto boardDto = createBoardDto();

            boardDto.setTitle(boardDto.getTitle()+i);
            boardDto.setContent(boardDto.getContent()+i);
            boardDto.setWriter(boardDto.getWriter()+i);
            boardDtoList.add(boardDto);
        }
    }

    //게시판 하단 정보 생성 테스트
    @Test
    void setPagingInfo() {
        Criteria criteria = new Criteria();
        criteria.setPage(5);
        criteria.setPerPageNum(10);

        List<BoardDto> resultBoardDtoList = boardDtoList.subList(50, 60);
        Assertions.assertEquals("내용51", resultBoardDtoList.get(0).getContent());
        Assertions.assertEquals("제목51", resultBoardDtoList.get(0).getTitle());
        Assertions.assertEquals("구훈51", resultBoardDtoList.get(0).getWriter());

        Assertions.assertEquals("내용60", resultBoardDtoList.get(9).getContent());
        Assertions.assertEquals("제목60", resultBoardDtoList.get(9).getTitle());
        Assertions.assertEquals("구훈60", resultBoardDtoList.get(9).getWriter());

        PageMaker pageMaker = new PageMaker(criteria);
        pageMaker.setPagingInfo(boardDtoList.size());

        Assertions.assertEquals(1, pageMaker.getStartPage());
        Assertions.assertEquals(10, pageMaker.getEndPage());

        Assertions.assertEquals(false, pageMaker.isPrev());
        Assertions.assertEquals(true, pageMaker.isNext());
    }
}