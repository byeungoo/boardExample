package com.board.example.controller;

import com.board.example.dto.BoardDto;
import com.board.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/test")
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

    @GetMapping(value="/")
    public String goBoardPage(){

        return "board";
    }

    @PostMapping(value="/")
    public @ResponseBody Map<String, BoardDto> insertBoard(@RequestBody BoardDto boardDto){

        Map<String, BoardDto> map = new HashMap<>();

        try{

        } catch(Exception e) {

        }

        return map;
    }

}
