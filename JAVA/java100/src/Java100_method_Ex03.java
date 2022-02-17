// 반환값이 없고 받는 인자값이 2개 있는 덧셈 메서드를 구현하시오.
// 이 문제는 자바의 메서드 작성법과 반환값, 인자값에 대한 이해가 있는지를 묻는 문제이다

public class Java100_method_Ex03 {
    //유형2. 반환값 X, 받는 인자값 O
    public static void  plus(int x, int y){
        System.out.printf("인자로 넘겨받은 2개의 값은 %d와 %d입니다 %n",x,y);

        //연산 출력
        int result = x+y;
        System.out.println("두 수를 더한 값은="+result);
    }
    public static void main(String[] args){
        //유형2. 반환값 X, 받는 인자값 O
        //메서드가 받는 인자값이 있다는 것은 호출부에서 파라미터 값을 넘긴다는 뜻
        int x=3,y=4;
        plus(x,y);
    }
}
