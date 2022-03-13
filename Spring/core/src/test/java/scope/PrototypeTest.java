package scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1"); //프로토타입 빈을 조회하기 직전에 생성되는걸 확인 --> 요청하면 스프링 컨테이너는 이 시점에 프로토타입 빈을 생성하고 의존관계 주입함
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class); //스프링 컨테이너에 같은 요청이 오면 "항상 새로운 프로토타입 빈을 생성해서 반환"함
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
//        prototypeBean1.destroy(); // 만약 종료 메서드를 호출해야한다면 직접 호출해 줘야함
//        prototypeBean2.destroy();
        ac.close();


    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }


}
/*
<출력 결과>
* find prototypeBean1
SingletonBean.init  //스프링 컨테이너에서 빈을 조회할 때 생성되고, 초기화 메서드도 실행된다
find prototypeBean2
SingletonBean.init //스프링 컨테이너에서 빈을 조회할 때 생성되고, 초기화 메서드도 실행된다
prototypeBean1 = scope.PrototypeTest$PrototypeBean@4f0100a7
prototypeBean2 = scope.PrototypeTest$PrototypeBean@3cdf2c61
20:30:05.408 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@13fd2ccd, started on Sun Mar 13 20:30:05 KST 2022

* */