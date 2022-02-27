package Oop;

// 객체 생성시 초깃값을 생성자 메서드에서 설정하는 클래스를 구현해보시오
/*
나이: 20, 이름: 홍길동
나이: 30, 이름: 이순신
나이: 40, 이름: 을지문덕
* */

class Person {
    //속성(필드)
    int age;
    String name;

    //생성자

    Person() {
    } //받는 인자값X

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //메서드
    void show() {
        System.out.println("나이: " + age + "," + " 이름: " + name);
    }
}

public class Java100_ex03 {
    public static void main(String[] args) {
        Person p1 = new Person(20, "홍길동");
        p1.show();
        Person p2 = new Person(30, "이순신");
        p2.show();
        Person p3 = new Person(40, "을지문덕");
        p3.show();
    }
}
