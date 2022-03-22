package com.study.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO extends CommonDTO {
    private Long idx; //번호(pk)

    private String title; //제목

    private String content; //내용

    private String writer;//작성자
    private int viewCnt;//조회수
    private String noticeYn;//공지여부
    private String secretYn;//비밀여부

}
