package com.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터는 컨트롤러의 URI에 접근하는 과정에서 무언가를 제어할 필요가 있을 때 사용됨. 정확히는 컨트롤러에 접근하기 전과 후로 나뉨
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//preHandle: 컨트롤러의 메서드에 매핑된 특정 URI를 호출했을 때 컨트롤러에 접근하기 전에 실행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			logger.debug("==============================================");
			logger.debug("======================BEGIN===================");
			logger.debug("Request URI==>"+request.getRequestURI());
			return super.preHandle(request, response, handler);
	}
	
	//postHandle: 컨트롤러를 경유한 다음, 화면(View)으로 결과를 전달하기 전에 실행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("=====================END===================");
		logger.debug("===========================================");
	}

}
