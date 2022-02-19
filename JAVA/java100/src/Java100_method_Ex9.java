// 반환값이 2개 있는 메서드를 구현해보시오.
// 메서드는 ( "korea", "USA" ) 입력시 소문자는 대문자로 대문자는 소문자로 출력되도록 구현한다.

import java.util.Arrays;

public class Java100_method_Ex9 {

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
