package com.board.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto {

    public BaseDto(){
        this.pageNum = 1;
        this.pageSize = 10;
    }

    private String regpeId;

    private String modpeId;

    private LocalDateTime regDts;

    private LocalDateTime modDts;

    private int pageNum;

    private int pageSize;

    private int startRnum;

    private int endRnum;

    private int totalCount;

    public void initPagingParam(){
        this.startRnum = this.pageSize*(this.pageNum-1);
        this.endRnum = this.pageSize*this.pageNum;
    }

}
