package com.board.example.dto;

import lombok.*;

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
