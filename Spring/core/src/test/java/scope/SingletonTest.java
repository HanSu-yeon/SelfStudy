package scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        System.out.println("find SingletonBean1");
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        System.out.println("find SingletonBean2");
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();

    }

    @Scope("singleton")
    static class SingletonBean{
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
SingletonBean.init   //스프링 컨테이너 생성 시점에 초기화 메서드가 실행
find SingletonBean1
find SingletonBean2
singletonBean1 = scope.SingletonTest$SingletonBean@6127a7e
singletonBean2 = scope.SingletonTest$SingletonBean@6127a7e
20:30:05.428 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework
SingletonBean.destroy
* */