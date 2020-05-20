package com.board.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto extends BaseDto{

    private Long id;

    private String title;

    private String content;

    private String writer;

    private int views;

}
