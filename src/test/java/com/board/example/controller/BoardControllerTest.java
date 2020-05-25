package com.board.example.controller;

import com.board.example.dto.BoardDto;
import com.board.example.service.BoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BoardControllerTest.class)
@AutoConfigureTestDatabase
public class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BoardController boardController;

    @MockBean
    BoardService boardService;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    public BoardDto createBoardDto(){
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setWriter("구훈");
        boardDto.setContent("내용");
        boardDto.setRegpeId("hoon");
        boardDto.setModpeId("hoon");
        boardDto.setId(1L);
        return boardDto;
    }

    //게시글 생성 페이지 호출 테스트
    @Test
    public void newWrite() throws Exception{
        mockMvc.perform(get("/board/newWrite")).andExpect(status().isOk());
    }

    //게시글 상세 페이지 조회 테스트
    @Test
    public void getBoard() throws Exception{
        BoardDto boardDto = new BoardDto();
        boardDto.setId(1L);
        given(boardService.getBoard(boardDto)).willReturn(boardDto);

        mockMvc.perform(get("/board/{id}", 1L))
         .andExpect(status().isOk())
         .andExpect(handler().methodName("getBoard"))
         .andDo(print());
    }

    @Test
    public void insertBoard() throws Exception{
        mockMvc.perform(post("/board")
                    .param("title", "제목")
                    .param("content", "내용")
                    .param("writer", "구훈"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }
}
