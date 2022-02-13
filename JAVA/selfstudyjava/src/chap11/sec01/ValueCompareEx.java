package chap11.sec01;

public class ValueCompareEx {
    public static void main(String[] args) {
        System.out.println("[-128~127 초과값일 경우");
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("=결과:" + (obj1 == obj2));
        System.out.println("언박싱후 ==결과: " + (obj1.intValue() == obj2.intValue()));
        System.out.println("equlas()결과: " + obj1.equals(obj2));
        System.out.println();

        //박싱된 값이 -128~127 범위의 값이라면 ==와 !=연산자로 내부의 값을 바로 비교할 수 있지만, 그 이외의 경우에는 언박상한 값을 얻어 비교해야함
        System.out.println("[-128~127 범위값일 경우");
        Integer obj3 = 10;
        Integer obj4 = 10;
        System.out.println("결과: " + (obj3 == obj4));
        System.out.println("언박싱후 ==결과: " + (obj3.intValue() == obj4.intValue()));
        System.out.println("equlas()결과: " + obj3.equals(obj4));
    }
}
