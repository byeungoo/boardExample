package com.board.example.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

    private int page;  //현재 페이지 번호

    private int perPageNum; //한 페이지당 보여줄 게시물의 개수

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPage() {
        if (this.page <= 0) {
            this.page = 1;
            return page;
        }
        return page;
    }

    public void setPage(int page){
        if(page <= 0){
            this.page = 1;
        } else{
            this.page = page;
        }
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        } else{
            this.perPageNum = perPageNum;
        }
    }

    public int getPageStart(){
        return (this.page-1) * perPageNum;
    }

}
