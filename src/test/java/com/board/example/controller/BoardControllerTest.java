package com.board.example.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    MultipartHttpServletRequest multipartRequest;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void test() throws Exception{
        mockMvc.perform(get("/board/newWrite")
        ).andExpect(status().isOk());
    }

}
