package com.board.example.controller;

import com.board.example.dto.BoardDto;
import com.board.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @GetMapping(value="board")
    public String insertBoard(){
        BoardDto board = new BoardDto();
        board.setTitle("테스트");
        board.setPassword("123");
        board.setWriter("훈");
        board.setContent("내용이다");
        board.setModpeId("hoon");
        board.setRegpeId("hoon");
        boardService.insertBoard(board);

        return "index";
    }

}
