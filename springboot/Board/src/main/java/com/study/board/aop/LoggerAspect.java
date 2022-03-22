package com.study.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  //스프링 컨테이너에 Bean으로 등록하기 위한 애너테이션. 개발자가 직접 정의한 클래스를 Bean으로 등록할 때 사용
@Aspect     //AOP기능을 하는 클래스의 클래스 레벨에 지정하는 애너테이션
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //Advice의 종류 중 하나. @Around는 메서드의 호출 자체를 제어할 수 있기 때문에 가장 강력한 기능이라고 볼 수 있다
    //execution: 포인트컷을 지정하는 문법
    @Around("execution(* com.study.board..controller.*Controller.*(..)) or execution(* com.study.board..service.*Impl.*(..)) or execution(* com.study.board..mapper.*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable{

        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();

        if (name.contains("Controller") == true) {
            type ="Controller ===>";
        } else if (name.contains("Service") == true) {
            type ="ServiceImpl ===>";
        } else if (name.contains("Mapper") == true) {
            type ="Mapper ===>";
        }

        logger.debug(type+name+"."+joinPoint.getSignature().getName()+"()");
        return joinPoint.proceed();
    }
}
