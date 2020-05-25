package com.board.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseDto{

    private Long id;

    private String title;

    private String content;

    private String writer;

    private int views;

}
