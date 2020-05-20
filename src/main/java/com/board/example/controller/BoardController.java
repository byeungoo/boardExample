package com.board.example.controller;

import com.board.example.dto.BoardDto;
import com.board.example.service.BoardService;
import com.board.example.service.IBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final IBoardService boardService;

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping(value = "newWrite")
    public String goBoardPage(){
        return "board";
    }

    @PostMapping
    public @ResponseBody Map<String, Object> insertBoard(BoardDto boardDto){
        Map<String, Object> result = new HashMap<>();

        try{

            boardDto.setModpeId("hoon");
            boardDto.setRegpeId("hoon");
            boardService.insertBoard(boardDto);

            result.put("resultMsg", "게시글 작성이 완료되었습니다.");
            result.put("resultCode", "success");

        } catch(RuntimeException e) {
            result.put("resultMsg", "게시글 작성에 실패하였습니다.");
            result.put("resultCode", "fail");
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping(value = "/insertMassTestBoard")
    public @ResponseBody Map<String, Object> insertMassTestBoard(@RequestBody BoardDto boardDto){
        Map<String, Object> result = new HashMap<>();

        try{

            boardDto.setModpeId("hoon");
            boardDto.setRegpeId("hoon");
            boardService.insertMassTestBoard(boardDto);

            result.put("resultMsg", "게시글 작성이 완료되었습니다.");
            result.put("resultCode", "success");

        } catch(RuntimeException e) {
            result.put("resultMsg", "게시글 작성에 실패하였습니다.");
            result.put("resultCode", "fail");
            e.printStackTrace();
        }

        return result;
    }

    @GetMapping(value = "/list")
    public String getBoardList(Model model, BoardDto boardDto){

        try{
            boardDto.initPagingParam();
            List<BoardDto> boardDtoList = boardService.getBoardList(boardDto);
            model.addAttribute("boardList", boardDtoList);
        } catch(RuntimeException e){
            e.printStackTrace();
        }

        return "boardList";
    }

    @GetMapping(value = "/{id}")
    public String getBoard(Model model , BoardDto boardDto){

        try{
            BoardDto resultDto = boardService.getBoard(boardDto);
            resultDto.setModpeId("hoon");
            boardService.increaseView(resultDto);
            model.addAttribute("board", resultDto);
        } catch(RuntimeException e){
            e.printStackTrace();
        }

        return "boardDtl";
    }

    @PutMapping(value="/{id}")
    public @ResponseBody Map<String, Object> updateBoard(BoardDto boardDto){

        Map<String, Object> result = new HashMap<>();

        try{
            boardDto.setModpeId("hoon");
            boardDto.setRegpeId("hoon");

            boardService.updateBoard(boardDto);

            result.put("resultMsg", "게시글 수정이 완료되었습니다.");
            result.put("resultCode", "success");
        } catch(RuntimeException e){
            result.put("resultMsg", "게시글 수정에 실패하였습니다.");
            result.put("resultCode", "fail");
            e.printStackTrace();
        }

        return result;
    }

    @DeleteMapping(value="/{id}")
    public @ResponseBody Map<String, Object> deleteBoard(BoardDto boardDto){

        Map<String, Object> result = new HashMap<>();

        try {
            boardService.deleteBoard(boardDto);
            result.put("resultMsg", "게시글 삭제가 완료되었습니다.");
            result.put("resultCode", "success");
        } catch(RuntimeException e){
            result.put("resultMsg", "게시글 삭제에 실패하였습니다.");
            result.put("resultCode", "fail");
            e.printStackTrace();
        }

        return result;
    }

}