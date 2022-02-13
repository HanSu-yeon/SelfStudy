package chap11.sec01;

//키보드로부터 읽은 바이트 배열을 문자열로 변환하는 방법
//System.in.read()메소드는 키보드에서 입력한 내용을 매개값으로 주어진 바이트 배열에 저장하고 읽은 바이트 수를 리턴
//public class KeyboardToStringEx {
//    public static void main(String[] args) throws IOException {
//        byte[] bytes = new byte[100]; //읽은 바이트를 저장하기 위한 배열 생성
//        System.out.print("입력:  ");
//        int readByteNo = System.in.read(bytes); //배열에 읽은 바이트를저장하고 읽은 바이트 수를 리턴
//
//        String str = new String(bytes, 0, readByteNo - 1);//배열을 문자열로 변환
//        System.out.println(str);
//    }
//}
