package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {


    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
        
        //ThreadA: A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자가 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);
        //Thread: 사용자A는 10000원을 기대했지만, 20000원 출력

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }



    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}