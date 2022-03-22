package com.study.board.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.List;
@Configuration
public class TransactionAspect {

    @Autowired
    private PlatformTransactionManager transactionManager;

    private static final String EXPRESSION = "execution(* com.study.board..service.*Impl.*(..))";

    @Bean
    public TransactionInterceptor transactionAdvice() {
        //트랜잭션에서 롤백을 수행하는 규칙. RollbackRuleAttribute생성자의 인자로 Exception클래스를 지정함-->어떠한 예외가 발생하던 무조건 롤백이 수행됨
        List<RollbackRuleAttribute> rollbackRules = Collections.singletonList(new RollbackRuleAttribute(Exception.class));

        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setRollbackRules(rollbackRules);
        transactionAttribute.setName("*"); //setName: 트랜잭션의 이름을 설정

        MatchAlwaysTransactionAttributeSource attributeSource = new MatchAlwaysTransactionAttributeSource();
        attributeSource.setTransactionAttribute(transactionAttribute);

        return new TransactionInterceptor(transactionManager, attributeSource);
    }

    @Bean
    public Advisor transactionAdvisor(){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(EXPRESSION); //AOP의 포인트컷 설정

        return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
    }
}
