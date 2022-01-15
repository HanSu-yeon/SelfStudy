package com.study.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

//전체적인 예외를 관리할 Eunm 클래스
@Getter
@AllArgsConstructor
public enum ErrorCode {
    /*
     * 400 BAD_REQUEST: 잘못된 요청
     * */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못되 요청입니다"),
    /*
     * 404 NOT FOUND: 리소스를 찾을 수 없음*/
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없다"),
    /*
     * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
     * */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다"),

    /*
     * 500 INTERNAL_SERVER_ERROR : 내부 서버 오류
     * */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다"),

    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글 정보를 찾을 수 없다"),
    ;

    private final HttpStatus status; //HttpStatus 타입의 멤버로, 예외에 대한 상태 코드와 이름을 처리하는 데 사용
    private final String message;//예외에 대한 응답 메시지(message)를 처리하는 데 사용되는 멤버

}
