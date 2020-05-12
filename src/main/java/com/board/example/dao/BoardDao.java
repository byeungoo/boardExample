package com.board.example.dao;

import com.board.example.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

    protected static final String NAMESPACE = "com.board.example.dao.boardMapper.";

    @Autowired
    private SqlSession sqlSession;

    public void insertBoard (BoardDto board){
        sqlSession.insert(NAMESPACE + "insertBoard", board);
    }

}
