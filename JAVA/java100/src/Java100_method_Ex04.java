// 반환값이 있고 받는 인자값이 없는 메서드를 구현해보시오.
// 이 문제는 자바의 메서드 작성법과 반환값, 인자값에 대한 이해가 있는지를 묻는 문제이다.


import java.util.Arrays;

public class Java100_method_Ex04 {

    public static int returnMethod() {
        int res = 100;
        res *= 100;
        return res; //반환값이 있으니까 return
    }

    public static void main(String[] args) {
        //유형3. 반환값 O, 받는 인자값 X
        //반환값이 있다는 것은 메서드(함수) 호출에 따른 리턴값이 있는 것이므로 호출시 리턴값을 받는 변수를 정의한다
        int result;

        result = returnMethod();

        //출력
        System.out.println("메서드 호출에 따르 리턴된 값은=" + result);

    }

    public static class Java100_method_Ex9 {

        public static String[] capitalMethod(String str1, String str2) {
            str1 = str1.toUpperCase();
            str2 = str2.toLowerCase();

            String[] ret = {str1, str2};
            return ret;
        }

        public static void main(String[] args) {
            //반환값O, 받는 인자값O
            String[] result = capitalMethod("korea", "USA");
            System.out.println(Arrays.toString(result)); //한번에 출력
            System.out.println(result[0] + "," + result[1]);

        }
    }
}
