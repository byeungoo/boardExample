package com.board.example.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

    private int page;

    private int perPageNum; //한 페이지당 보여줄 게시물의 개수

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public void getPage(int page){
        if(page<=0){
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPageStart(){
        return (this.page-1) * perPageNum;
    }

}
