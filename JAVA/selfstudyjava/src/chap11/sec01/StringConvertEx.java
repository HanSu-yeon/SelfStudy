package chap11.sec01;

public class StringConvertEx {
    public static void main(String[] args) {
        String strData1 = "200";
        int intData1 = Integer.parseInt(strData1);//200을 정수로 변환
        System.out.println(((Object) intData1).getClass().getSimpleName());
        int intData2 = 150;
        String strData2 = String.valueOf(intData2);//숫자 150을 문자열로 변환하는 코드드
        System.out.println(strData2.getClass().getSimpleName());

    }
}

