package Oop;


abstract class Car {
    abstract void run();
}

class Ambulance extends Car {
    @Override
    void run() {
        System.out.println("앰블런스 지나가요 삐뽀삐뽀");
    }
}

class Cultivator extends Car {
    @Override
    void run() {
        System.out.println("경운기 지나가요 덜컹덜컹");
    }
}

class SportsCar extends Car {
    @Override
    void run() {
        System.out.println("스포치카 지나가요 쌔앵");

    }
}

public class Java100_ex11 {
    public static void main(String[] args) {
//        Car c1 = new Ambulance();
//        Car c2 = new Cultivator();
//        Car c3 = new SportsCar();
//
//        c1.run();
//        c2.run();
//        c3.run();

        //리팩토링
        //1.배열 길이가 3인 Car 객체 배열 선언
//        Car[] cars = new Car[3]; //배열 공간 3개가 만들어진다 -->ㅁㅁㅁ
//        System.out.println(cars[0]); //null-->각 배열에는 아직 null값만 존재
//        cars = new Car[]{new Ambulance(), new Cultivator(), new SportsCar()}; //cars배열 초기화

        //2. 1번 방법 말고 --> 자식 클래스로 객체 생성,타입은 부모타입으로 --> 이렇게 생성된 객체들로 바로 배열 초기화 --> 다형성 덕분
        Car[] cars = {new Ambulance(), new Cultivator(), new SportsCar()};

        //3. 반복문 돌면서 각 객체의 run()메서드 호출
        for (int i = 0; i < cars.length; i++) {
            cars[i].run();
        }

        //4.향상된 for문
        System.out.println("--------------------");
        for (Car obj : cars) {
            obj.run();
        }
    }
}
