package chap05;

public class ArrayEx6 {
    public static void main(String[] args) {
        //큰 금액의 동전을 우선적으로 거슬러 줘야한다
        int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        System.out.println("money = " + money);
/* 내가 푼 방식
        int fiveHundred = 0;
        int oneHundred=0;
        int fifty=0;
        int ten =0;

        for (int i = 0; i < coinUnit.length; i++) {

            //알맞은 코드를 넣어 완성하시오오
            if (coinUnit[i] == 500) {
                fiveHundred = money / coinUnit[i];
                money = money % coinUnit[i];
            } else if (coinUnit[i] == 100) {
                oneHundred = money / coinUnit[i];
                money = money % coinUnit[i];
            } else if (coinUnit[i] == 50) {
                fifty = money / coinUnit[i];
                money = money % coinUnit[i];
            }else{
                ten = money / 10;
                money = money % 10;
            }
        }
        System.out.println("fiveHundred = " + fiveHundred);
        System.out.println("oneHundred = " + oneHundred);
        System.out.println("fifty = " + fifty);
        System.out.println("ten = " + ten);

 */

        //다른 풀이
        for (int i = 0; i < coinUnit.length; i++) {
            System.out.println(coinUnit[i]+"원: "+money/coinUnit[i]);
            money = money % coinUnit[i];
        }
    }
}
