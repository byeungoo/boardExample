package com.board.example.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMaker {

    private int totalCount;  //게시판 전체 게시글 수

    private int startPage; //하단 시작 페이지번호

    private int endPage; //하단 종료 페이지번호

    private boolean prev;

    private boolean next;

    private int displayPageNum = 10; //하단에 보여줄 페이지 번호 개수

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

        //실제 게시글 총 페이지 번호와 비교
        if(endPage > tempPage){
            endPage = tempPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }

}
