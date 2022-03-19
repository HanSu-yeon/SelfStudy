package chap06;

public class Exercise6_22 {
    /*기능:주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다
    * 모두 숫자로만 이루어져 있으면 true를 반환하고
    그렇지 않으면 false를 반환한다.
    만일 주어진 문자열이 null 이거나 빈문자열 “”이라면 false를 반환한다. */

    //방법1
//    static boolean isNumber(String str){
//        for (int i = 0; i < str.length(); i++) {
//            if (!Character.isDigit(str.charAt(i))) {
//               return false;
//            }
//        }
//        return true;
//    }

    //방법2
    static boolean isNumber(String str) {

        if(str == null || str.equals(""))
            return false;
        //charAt(int i)을 이용해서 문자열에서 한 문자씩 차례대로 읽어와
        for (int i = 0; i < str.length(); i++) {
            //char타입의 변수 tmp에 저장
            char tmp = str.charAt(i);
            //읽어온 문자(tmp)가 숫자가 아니면 false를 반환
            if (tmp < '0' || tmp > '9') { //if(!('0'<=tmp && tmp <= '9'))와 같다
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));

        str = "1234o";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));

    }


}
