package chap11.sec01;

public class ExitEx {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                //System.exit(0); => "마무리 코드"출력 x
                break; //=> 중단하고 "마무리 코드"출력
            }
        }
        System.out.println("마무리 코드");
    }
}
