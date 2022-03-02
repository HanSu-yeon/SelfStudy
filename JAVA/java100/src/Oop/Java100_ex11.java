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
        Car c1 = new Ambulance();
        Car c2 = new Cultivator();
        Car c3 = new SportsCar();

        c1.run();
        c2.run();
        c3.run();

    }
}
