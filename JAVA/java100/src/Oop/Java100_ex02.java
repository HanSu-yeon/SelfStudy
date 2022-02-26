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
        System.out.println("------진수 지정-------------");
        System.out.println(Integer.parseInt("2022", 10));
        System.out.println(Integer.parseInt("1011", 2)); //1011(2진수)를 10진수로
        System.out.println(Integer.parseInt("1004", 8)); //1011(8진수)를 10진수로-->516
        /*8진수 계산법
        1004
            4*(8^0)=4
            0*(8^1)=
            0*(8^2)=
            1*(8^3)=512
        */
        System.out.println(Integer.parseInt("A", 16));//10
        /*
         * 10진수--> 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
         * 16진수--> 0 1 2 3 4 5 6 7 8 9 A  B  C  D  E  F
         * */
        System.out.println(Integer.parseInt("FF", 16)); //255
        /*FF-->10진수로
         * 15*(16^0) = 15
         * 15*(16^1) = 240
         *                  -->255
         * */

    }
}
