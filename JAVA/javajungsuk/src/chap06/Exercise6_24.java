package chap06;
//기능: 주어진 값의 절대값을 반환한다
public class Exercise6_24 {
    static int abs(int value) {

    //방법1
//        if (value < 0) {
//            value = value * -1;
//        }
//        return value;
    //방법2
        return value>=0?value:-value;
    }

    public static void main(String[] args) {
        int value =5;
        System.out.println(value+"의 절대값: "+abs(value));
        value =-10;
        System.out.println(value+"의 절대값: "+abs(value));
    }
}
//5의 절대값: 5
//-10의 절대값: 10