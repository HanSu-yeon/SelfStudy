package designpattern.decorator;

public class Client {
    public static void main(String[] args) {
        RoadDisplay road = new RoadDisplay();
        road.draw(); //기본 도로 표시
        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); //기본 도로 표시 + 차선 표시
        Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw(); //기본 도로 표시 + 교통량 표시

        //각 road, roadWithLane, roadWithTraffic 객체의 접근이 모두 Display 클래스를 통해 이루어 진다.

        //기본 도로 표시 + 교통량 표시 + 차선 표시
        Display roadWithLandAndTraffic =
                new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLandAndTraffic.draw();
    }
}
