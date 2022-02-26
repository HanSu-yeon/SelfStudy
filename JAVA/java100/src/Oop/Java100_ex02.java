package Oop;

// 문자열을 숫자로 바꿔서 연산해보시오.
// 이때, 인자값으로 진수를 지정해서 출력해보시오.

/**
 * 문자열을 숫자로 변환시키는 방법: Integer.parseInt() 사용
 * parseInt() --> Integer 클래스의 static으로 지정 --> 따라서, 객체의 생성 없이 바로 "클래스명.parseInt()"로 직접 사용이 가능
 */
public class Java100_ex02 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int result = a + b;
        System.out.println("a+b = " + result); //3
        String a2 = "1";
        String b2 = "2";
        String result2 = a2 + b2;
        System.out.println("a+b = " + result2); //12
        System.out.println(result2.getClass().getName());
        //문자열을 숫자로 바꿔서 연산
        int a2_int = Integer.parseInt(a2);
        int b2_int = Integer.parseInt(b2);
        int result3 = a2_int + b2_int;
        System.out.println(result3);

    }
}
