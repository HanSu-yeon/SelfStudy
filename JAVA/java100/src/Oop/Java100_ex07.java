package Oop;

/*
// 객체에 대한 참조값을 요소로 가지는 "객체 배열"을 생성하는 코드를 구현하시오.
// 반복문을 사용해서 객체를 생성해보시오.
[ 결과 출력 ]
-------------------------------------------------------------------------------------------------------------------------------------------
0번 후보자 --> 나이 : 20
1번 후보자 --> 나이 : 21
2번 후보자 --> 나이 : 22
3번 후보자 --> 나이 : 23
4번 후보자 --> 나이 : 24
5번 후보자 --> 나이 : 25
6번 후보자 --> 나이 : 26
7번 후보자 --> 나이 : 27
8번 후보자 --> 나이 : 28
9번 후보자 --> 나이 : 29
*/

class Person5 {
    //Feild
//    private String name;
//    private int age;
    String name;
    int age;

    //Constructor
    Person5() {
    }

    Person5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Method
    public String getName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }
}

public class Java100_ex07 {
    public static void main(String[] args) {
        //1. 객체 생성
        Person5[] pa; //Person5 타입의 객체 배열 변수 pa 선언
        pa = new Person5[9]; //Person5객체의 참조값을 원소로 가지는 배열 공간을 9개 생성--> 9명 객체 생성할테니 주소 저장해라

        //2. 반복문(for)을 돌면서 Person5객체 생성
        for (int i = 0; i < pa.length; i++) {
            pa[i] = new Person5(i + "번", 20 + i);//i만 입력하면 안되니 문자열을 붙여 문자열로 전달한다
            //2-1. getter, setter 메서드 사용해서 출력
            System.out.println(pa[i].getName() + " 후보자의 나이는 " + pa[i].getAge() + "살");

            //2-2. 배열 인덱스를 사용해 출력 --> 단, 이렇게 쓰려면 private선언을 삭제하고 써야함
//            System.out.println(pa[i].name + " 후보자의 나이는 " + pa[i].age + "살");
            //2-3. printf()
//            System.out.printf("%s 후보자의 나이는 %d살\n", pa[i].name, pa[i].age);
        }
    }
}
