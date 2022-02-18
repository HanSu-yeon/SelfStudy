//기본형 타입과 참조형 타입의 다양한 메서드 호출 방식


class TestNumber {
    int num;

    TestNumber(int num) {
        this.num = num;
    }
}

public class Java100_method_Ex07 {

    //1.Call by value: 값에 의한 호출 --> "값에 의해서 (메서드를)호출"
    //메서드로 인자값을 넘길 때 해당 값을 복사하여 넘기는 방식 --> 따라서 sum()메서드 내부에서는 복사된 값으로 처리를 한다
    public static void sum(int a) {
        a += 400;
        System.out.println("Call by value >>  " + a);//500
    }

    //Call by reference 방식으로 수정
    public static void sum2(Integer a2) {
        a2 += 200;
        System.out.println("Call by reference >>  " + a2); //300
    }

    public static void sum3(TestNumber a3) {
        System.out.println("Call by reference--real 주소값>>  "+a3); //전달받은 a3값(TestNumber주소)을 출력해보면 주소가 들어있음을 알 수 있다 TestNumber@79b4d0f
        System.out.println("Call by reference--real >>  "+a3.num); //100
        a3.num = a3.num+400;
        System.out.println("더한값   " +a3.num); //500
    }

    public static void main(String[] args) {
        //1.Call by value변수 선언 및 메서드 호출
        int a = 100;
        sum(a);
        //출력
        System.out.println("Call by value >>  " + a);//100

        //Call by reference 방식으로 수정 (틀렸음)
        //Wrapper 클래스의 Integer 클래스 타입으로 변수 a2를 선언하고 new로 객체를 생성하여 해당 주소 값을 메서드로 보낸다 --> 90% 정답
        Integer a2 = new Integer(100);
        sum2(a2);
        System.out.println("Call by reference >>  " + a2);//100

        ////Call by reference 방식--> 정답
        TestNumber a3 = new TestNumber(100);
        sum3(a3); //주소값에 의해서 sum 메소드를 호출하고 있다
        System.out.println("Call by reference--real 주소값 >>  "+a3); //TestNumber@79b4d0f
        System.out.println("Call by reference--real >>  "+a3.num); //500

    }

}
