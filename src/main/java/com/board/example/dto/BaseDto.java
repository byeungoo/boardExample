package com.board.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto {

    private String regpeId;

    private String modpeId;

    private LocalDateTime regDts;

    private LocalDateTime modDts;

}
