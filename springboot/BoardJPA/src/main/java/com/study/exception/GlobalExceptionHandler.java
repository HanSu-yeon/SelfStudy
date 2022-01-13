package com.study.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice 	
@Slf4j //이 어노테이션이 서언된 클래스에 자동으로 로그 객체를 생성
public class GlobalExceptionHandler {
	/*
	 * Developer Custom Exception
	 * */
	//ResponseEntity<T>: HTTP Request에 대한 응답 데이터를 포함하는 클래스로, <Type>에 해당하는 데이터와 HTTP상태 코드를 함께 리턴할 수 있다 
	//예외가 발생했을 때, ErrorResponse형식으로 예외 정보를 Response로 내려주게 된다
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e){
		log.error("handleCustomerException: {}",e.getErrorCode());
		return ResponseEntity.status(e.getErrorCode().getStatus().value()).body(new ErrorResponse(e.getErrorCode()));
	}
	/*
	 * HTTP 405 Exception
	 * */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e){
		log.error("handleHttpRequestMethodNotSupportedException:{}",e.getMessage());
		
		return ResponseEntity.status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value())
				.body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
	}
	
	/*
	 * HTTP 500 Exception
	 * */
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(final Exception e){
		log.error("handleException:{}",e.getMessage());
		return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
				.body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
	}
}
