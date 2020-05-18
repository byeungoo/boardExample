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

    @GetMapping
    public String goBoardPage(){

        return "board";
    }

    @PostMapping
    public @ResponseBody Map<String, Object> insertBoard(BoardDto boardDto){

        Map<String, Object> result = new HashMap<>();

        try{
            boardDto.setModpeId("hoon");
            boardDto.setRegpeId("hoon");
            result = boardService.insertBoard(boardDto);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 등록에 실패하였습니다.");
        }

        return result;
    }

}
