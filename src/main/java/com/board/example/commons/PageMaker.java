package com.board.example.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMaker {

    private int totalCount;

    private int startPage;

    private int endPage;

    private boolean prev;

    private boolean next;

    private int displayPageNum = 10;

    private Criteria criteria;

    public PageMaker(Criteria criteria){
        this.criteria = criteria;
    }

    public void setPagingInfo(int totalCount){
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData(){
        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum)  *displayPageNum);
        startPage = (endPage-displayPageNum) + 1;
        int tempPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

        if(endPage > tempPage){
            endPage = tempPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }

}
