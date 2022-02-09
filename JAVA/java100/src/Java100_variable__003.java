/**
자바의 Primitive Data Type의 바이트 크기와 비트 크기를 출력하는 코드를 구현하시오.
 정수형 타입과 문자형 타입에 대해서만 구현한다.
이때, 각 타입의 최댓값과 최솟값도 같이 구하여 출력하시오.
 */


public class Java100_variable__003 {
    public static void main(String[] args) {
        //byte(1byte==8bit)              바이트계산           비트계산               최솟값                 최댓값
        System.out.println("byte: "+Byte.BYTES+"(byte)-->"+Byte.SIZE+"(bit)\t"+Byte.MIN_VALUE +"~"+Byte.MAX_VALUE);
        //short(2byte=16bit)
        System.out.println("short: "+Short.BYTES+"(byte)-->"+Short.SIZE+"(bit)\t"+Short.MIN_VALUE+"~"+Short.MAX_VALUE);
        //int(4byte=32bit)
        System.out.println("int: "+Integer.BYTES+"(byte)-->"+Integer.SIZE+"(bit)\t"+Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
        //long(8byte=64bit)
        System.out.println("long: "+Long.BYTES+"(byte)-->"+Long.SIZE+"(bit)\t"+Long.MIN_VALUE+"~"+Long.MAX_VALUE);
        //char(2byte=16bit)   char타입은 문자형 타입이기 때문에 Int로 타입 변환 후 출력
        System.out.println("char: "+Character.BYTES+"(byte)-->"+Character.SIZE+"(bit)\t"+ (int)Character.MIN_VALUE+"~"+(int)Character.MAX_VALUE);
    }
}
/**
 * short와 char는 같은 크기를 갖는데 최대,최소 범위는 다르다
  => char는 문자형 타입이기 때문에 음수를 가질 수 없고 -32768 이 범위만큼 더 많이 가질 수 있음(0~65535)
    참고)short 최대,최소 범위: -32768~32767
 * */