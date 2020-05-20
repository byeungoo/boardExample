package com.board.example.dao;

import com.board.example.commons.Criteria;
import com.board.example.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao implements IBoardDao{

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

    public List<BoardDto> getBoardList(Criteria criteria){
        return sqlSession.selectList(NAMESPACE + "getBoardList", criteria);
    }

    public void increaseView(BoardDto boardDto){
        sqlSession.update(NAMESPACE + "increaseView", boardDto);
    }

    public int getBoardTotalCnt(){
        return sqlSession.selectOne(NAMESPACE + "getBoardTotalCnt");
    }

}
