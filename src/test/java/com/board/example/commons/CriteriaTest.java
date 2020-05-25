package com.board.example.commons;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CriteriaTest {


    //페이징 기준 데이터 생성 테스트
    @Test
    public void initCriteriaTest(){
        Criteria criteria = new Criteria();
        criteria.setPage(-1);
        Assertions.assertEquals(1, criteria.getPage());

        criteria.setPerPageNum(-100);
        Assertions.assertEquals(10, criteria.getPerPageNum());
    }

}