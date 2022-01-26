package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//@Getter,@Setter는 롬복에서 제공해주는 기능
@Getter
@Setter
public class BoardDTO {
    //번호(pk)
    private Long idx;
    //제목
    private String title;
    //내용
    private String content;
    //작성자
    private String writer;
    //조회수
    private int viewCnt;
    //공지여부
    private String noticeYn;
    //비밀여부
    private String secretYn;
    //삭제여부
    private String deleteYn;
    //등록일
    private LocalDateTime insertTime;
    //등록일
    private LocalDateTime updateTime;
    //삭제일
    private LocalDateTime deleteTime;

}
