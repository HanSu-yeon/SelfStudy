// 2개의 정수형 값을 리턴하는 메서드를 구현하시오.
// 이 문제는 두개의 리턴 값을 반환하는 메서드 작성법을 아는지에 대해서 묻는 문제이다.

import java.util.Arrays;

public class Java100_method_Ex08 {
    public static int[] testMethod() {
        int num1 = 100;
        int num2 = 200;
        int num3 = 300;
        return new int[]{num1, num2,num3}; //배열로 반환

    }


    public static void main(String[] args) {
        //1. 배열 변수 선언 --> 메서드로 부터 반환받을 값이 배열이기 때문에
        int result[]=testMethod();

        //2. 출력
        System.out.println(result); // ※참조형 타입인 객체나 배열 등 변수명 자체를 출력하면 "주소값"이 출력된다※
        System.out.println(result[0]+","+result[1]); //100과 200 출력
        System.out.println(Arrays.toString(result));//[100, 200, 300] --> 한번에 모든 요소를 출력(반복문 사용 없이!!)
    }

}
