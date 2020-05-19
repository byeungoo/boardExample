package com.board.example.dao;

import com.board.example.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao {

    private static final String NAMESPACE = "com.board.example.dao.boardMapper.";

    @Autowired
    private SqlSession sqlSession;

    public void insertBoard (BoardDto boardDto){
        sqlSession.insert(NAMESPACE + "insertBoard", boardDto);
    }

    public BoardDto getBoard(BoardDto boardDto) {
        return sqlSession.selectOne(NAMESPACE + "getBoard", boardDto);
    }

    public void updateBoard(BoardDto boardDto){
        sqlSession.update(NAMESPACE + "updateBoard", boardDto);
    }

    public void deleteBoard(BoardDto boardDto){
        sqlSession.delete(NAMESPACE + "deleteBoard", boardDto);
    }

    public List<BoardDto> getBoardList(BoardDto boardDto){
        return sqlSession.selectList(NAMESPACE + "getBoardList", boardDto);
    }

    public void increaseView(BoardDto boardDto){
        sqlSession.update(NAMESPACE + "increaseView", boardDto);
    }

}
