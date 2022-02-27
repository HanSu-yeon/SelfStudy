package Oop;

// 클래스의 상속을 코드로 구현해보시오. 메서드 오버라이딩에 대해서 설명하고 구현해보시오
//결과값
/*
부모 클래스 → 걸어가고 있어요~
이름 : 슈퍼맨, 나이 : 20, 성별 : 1, 파워 : 100
이름 : 원더우먼, 나이 : 30, 성별 : 1, 파워 : 100
이름 : 원더우먼, 나이 : 30, 성별 : 2, 파워 : 300
자식 클래스 → 2배로 빨리 걸어가고 있어요~
*/

//공통적으로 가지는 속성,기능,동작들을 부모 클래스에 작성한다
class Person2 {
    //Field
    int gender;
    int power;

    //Constructor
    Person2() {
        this.gender = 1; //1=남성, 2=여성
        this.power = 100; //기본 파워
    }

    //Method
    void walk() {
        System.out.println("걸어가고 있어요");
    }
}

class Hero extends Person2 {
    //Field
    String name;
    int age;

    //Constructor
    Hero() {
    }

    Hero(String name, int age) {
        super();//부모 클래스의 생성자를 호출해 달라고 명시. 생략 가능
        this.name = name;
        this.age = age;
    }
    //Method

    @Override
    void walk() {
        System.out.println("2배로 빨리 걸어가고 있어요");
    }

    void eat() {
        System.out.println("박먹고 있음");

    }

    void displayPerson() {
        System.out.println("이름: " + name + " 나이: " + "성별: " + gender + " 파워: " + power);
    }
}

class Villain {
}

public class Java100_ex04 {


    public static void main(String[] args) {
        //객체 생성
        Person2 p = new Person2();
        p.walk();

        //상속을 통한 Hero객체 생성
        Hero h1 = new Hero("슈퍼맨", 20);
        System.out.println(h1.name);
        System.out.println(h1.age);
        System.out.println(h1.gender);//부모 클래스 필드(변수)
        System.out.println(h1.power);//부모 클래스 필드(변수)
        h1.walk();
        h1.displayPerson();

        //원더우먼 객체 생성
        Hero h2 = new Hero("원더우먼", 30);

        h2.displayPerson();
        h2.gender = 2;
        h2.power = 300;
        h2.displayPerson();
    }

}
