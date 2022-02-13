package chap11.sec01;

public class MathEx {
    public static void main(String[] args) {
        //abs 절대값
        int v1 = Math.abs(-5);
        double v2 = Math.abs(-3.14);
        System.out.println(v1);
        System.out.println(v2);
        //ceil 올림값
        double v3 = Math.ceil(5.3);
        double v4 = Math.ceil(-5.3);
        System.out.println(v3);
        System.out.println(v4);

        //floor 버림값
        double v5 = Math.floor(5.3);
        double v6 = Math.floor(-5.3);
        System.out.println(v5);
        System.out.println(v6);
        //max 최대값, min 최소값
        int v7 = Math.max(5, 9);
        double v8 = Math.min(5.3, 2.5);
        System.out.println(v7);
        System.out.println(v8);

        //random 랜덤값
        double v9 = Math.random();
        System.out.println(v9);
        //rint 가까운정수의 실수값
        double v10 = Math.rint(5.3);
        double v11 = Math.rint(5.7);
        System.out.println(v10);
        System.out.println(v11);
        //round 반올림값
        long v12 = Math.round(5.3);
        long v13 = Math.round(5.7);
        System.out.println(v12);
        System.out.println(v13);

        //임의의 주사위의 눈 얻기
        System.out.println("------------임의의 주사위의 눈 얻기(1~6)---------");
        //0.0<= Math.random()<1.0
        //0.0*6<= Math.random()*6 <1.0*6 --> 0.0<=...<6.0범위에 속하는 하나의 double타입의 값을 얻을 수 있음
        //0<=...<6 사이의 범위에 속하는 값을 얻기 위해 int타입으로 강제 타입 변환
        //(int) (0.0*6)<= (int) (Math.random()*6) <(int)(1.0*6) -->0<=...<6
        //(int) (0.0*6)+1<= (int) (Math.random()*6)+1 <(int)(1.0*6)+1
        //위 과정을 자바 코드로 표현하면
        int num = (int) (Math.random() * 6) + 1;
        System.out.println("주사위눈 " + num);
    }
}
