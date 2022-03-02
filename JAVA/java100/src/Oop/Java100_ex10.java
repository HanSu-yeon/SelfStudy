package Oop;

class Person8 {
    String str1 = "난 부모 클래스";

    void method1() {
        System.out.println("에이에이에이");
    }

    void ppp() {
        System.out.println("ppp");
    }
}

class Student3 extends Person8 {
    String str2 = "난 자식 클래스";

    @Override
    void method1() {
        System.out.println("오버라이딩-aaa");
    }

    void sss() {
        System.out.println("sss");
    }
}

public class Java100_ex10 {
    public static void main(String[] args) {
        //객체 생성--> 부모+자식 클래스의 모든 자원을 다 쓸 수 있다
        Student3 s1 = new Student3();
        System.out.println(s1.str1);
        System.out.println(s1.str2);
        //자식(하위) 클래스로 객체를 만들면서 타입은 부모(상위) 타입으로 쓰는 것이 가능 --> 다형성
        //객체 생성 --> 범위는 부모의 자원만을 쓸 수 있다
        Person8 s2 = new Student3();
        //만약 자식의 메서드를 바로 호출하고 싶다면? --> 캐스트 하기
        ((Student3) s2).sss();

        Person8 p1 = new Person8();
        //상위(부모) 클래스로 객체를 생성하면서 타입은 하위(자식)타입을 쓰는 경우 --> Err
        //Student3 p2 =new Person8();
    }
}
