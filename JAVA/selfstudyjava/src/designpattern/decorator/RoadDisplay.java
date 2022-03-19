package designpattern.decorator;

//기본 도로 표시 클래스(기본 기능)
public class RoadDisplay extends Display {

    @Override
    public void draw() {
        System.out.println("기본 도로 표시");
    }
}
