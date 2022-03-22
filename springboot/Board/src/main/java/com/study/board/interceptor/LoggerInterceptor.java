package com.study.board.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override //preHandle: 컨트롤러에 접근하기 전에 실행되는 메서드로 사용자가 화면에서 어떠한 기능을 수행했을 때 해당 기능과 매핑된 URI의 정보를 콘솔 로그 출력
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("============================================");
        logger.debug("=================BEGIN============");
        logger.debug("Request URI ==>" + request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    @Override  //postHandle: 컨트롤러를 경유한 다음, 화면(View)으로 결과를 전달하기 전에 실행되는 메서드로 요청을 끝을 알리는 로그를 콘솔에 출력
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("=================END============");
        logger.debug("============================================");
    }
}
