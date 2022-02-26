// FarmMachine의 속성과 동작들을 가지는 클래스를 코드로 구현하고 객체를 생성하여 동작시켜보시오.
//[ 결과 출력 ]
//        1000000
//        2020
//        red
//        Farm-machine is moving.
//        Fram-machine is digging.
//        Fram-machine is grinding.

/**
 * <클래스 만들기>
 * - 객체의 특징 -->속성
 * - 객체의 동작 -->메서드
 */
package Oop;

import java.text.DecimalFormat;

class FarmMachine {
    /**
     * 1. 속성(특징)
     */
    int price; //가격
    int year; //연식
    String color; //색상

    /**
     * 2. 동작/기능/행동(method) --> 농기계마다 동작이 다양할 것이므로 처음에는 공통적인 동작을 생각해본다
     */
    void move() {
        System.out.println("Farm-machine is moving.");
    }

    void dig() {
        System.out.println("Fram-machine is digging.");
    }

    void grind() {
        System.out.println("Fram-machine is grinding.");

    }
}

public class Java100_oop_Ex01 {


    public static void main(String[] args) {
        //1. 객체 생성
        //new는 객체를 생성하고 주소값을 반환한다
        FarmMachine fm = new FarmMachine();
        System.out.println(fm); //이 객체의 주소값: Oop.FarmMachine@3ac3fd8b

        //2. 생성된 객체에 속성 값 입력하기
        fm.price = 1000000;
        fm.year = 2022;
        fm.color = "green";

        //금액을 1000단위로 콤마 찍어 출력하기1
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format((fm.price));
        //금액을 1000단위로 콤마 찍어 출력하기2
        String money2 = String.format("%,d", 1000000);
        System.out.println("가격>>" + fm.price);
        System.out.println("가격(콤마 찍어 출력)1>>" + money);
        System.out.println("가격(콤마 찍어 출력)2>>" + money2);
        System.out.println("연식>>" + fm.year);
        System.out.println("색상>>" + fm.color);

        //4. 동작 수행하기
        fm.move();
        fm.grind();
        fm.dig();
    }

}
