package com.study.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Custom 예외 처리용(ErrorCode) Exception클래스
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}
