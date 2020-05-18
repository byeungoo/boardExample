package com.board.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDto {

    public BoardDto(){

    }

    private Long id;

    private String title;

    private String content;

    private String writer;

    private String password;

    private String regpeId;

    private String modpeId;

    private LocalDateTime regDts;

    private LocalDateTime modDts;

}
