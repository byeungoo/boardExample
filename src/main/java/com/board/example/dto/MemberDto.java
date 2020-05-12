package com.board.example.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberDto {

    private String memberId;

    private String memberPwd;

    private String memberName;

    private String memberGender;

    private String email;

}
