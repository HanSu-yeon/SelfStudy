package chap11.sec01;

public class BoxingUnBoxingEx {
    public static void main(String[] args) {
        //박싱
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer("200");
        Integer obj3 = new Integer("300");

        //언박싱
        int value1 = obj1.intValue();
        int value2 = obj2.intValue();
        int value3 = obj3.intValue();

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);


        //자동 박싱
        Integer obj4 = 100;
        System.out.println("value: " + obj4.intValue());
        //대입 시 자동 언박싱
        int value4 = obj4;
        System.out.println("value: " + value4);

        //연산 시 자동 언박싱
        int result = obj4 + 100;
        System.out.println("result: " + result);
    }
}
