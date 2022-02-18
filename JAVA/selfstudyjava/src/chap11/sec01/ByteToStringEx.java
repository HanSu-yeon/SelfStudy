package chap11.sec01;

public class ByteToStringEx {
    public static void main(String[] args) {
        byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

        //각각의 바이트를 문자로 바꾸어서 결합한 다음 문자열로 만드는 생성자
        String str1 = new String(bytes); //생성자의 매개값으로 byte배열 제공
        System.out.println(str1); //Hello Java

        String str2 = new String(bytes, 6, 4);
        System.out.println(str2);//Java
    }
}
