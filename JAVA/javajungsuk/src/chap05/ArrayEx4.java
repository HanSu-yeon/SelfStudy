package chap05;
//2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오
public class ArrayEx4 {
    public static void main(String[] args) {
            int[][] arr = {
                    { 5, 5, 5, 5, 5},
                    {10,10,10,10,10},
                    {20,20,20,20,20},
                    {30,30,30,30,30}
            };

            int total = 0;
            float average =0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
        }
//        average = (float) total / 20;
        average = total / (float) (arr.length * arr[0].length); //더 나은 방법
        System.out.println("total = " + total);
        System.out.println("average = " + average);
        }
}
/*
1. int형(4 byte)보다 크기가 작은 자료형은 int형으로 형변환 후에 연산을 수행한다
    - byte / short → Int / Int → Int
2. 두 개의 피연산자 중 자료형의 표현범위가 큰 쪽에 맞춰서 형변환 된 후 연산을 수행한다
    - int / float → float / float →float
3. 정수형 간의 나눗셈에서 0으로 나누는 것은 금지되어 있다
*/