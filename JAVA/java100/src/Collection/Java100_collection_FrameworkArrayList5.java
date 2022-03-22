package Collection;

/*



 * 1부터 10사이의 숫자가 무작위로 10개 출력되는 코드를 구현해보시오
 * 이때 0은 출력되면 안된다
 * */
public class Java100_collection_FrameworkArrayList5 {
    public static void main(String[] args) {
        //1.반복문 -->랜덤 숫자 생성
        //랜덤 숫자 생성중 0을 제외하려면? 결과로 나오는 숫자에 1을 더해준다
        for (int i = 0; i < 10; i++) {
            System.out.print(((int) (Math.random() * 10) + 1) + "\t");
        }

    }
}
