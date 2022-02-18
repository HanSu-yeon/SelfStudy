package chap11.sec01;

//Class 객체 정보 얻기
public class ClassEx {
    public static void main(String[] args) throws ClassNotFoundException {
        //첫번째 방법
        Class clazz = Car.class;
        //두번째 방법
        Class clazz2 = Class.forName("chap11.sec01.Car");
        //세번째 방법
        Car car = new Car();
        Class clazz3 = car.getClass();

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);
        //클래스의 전체 이름
        System.out.println(clazz.getName());
        //패키지를 제외한 클래스 이름
        System.out.println(clazz.getSimpleName());
        //패키지 이름 출력
        System.out.println(clazz.getPackage().getName());
    }
}
