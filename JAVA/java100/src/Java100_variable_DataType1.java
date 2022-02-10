/**
 정수, 실수, 문자형 타입의 변수 사용에서 틀린 곳을 찾아서 모두 수정하시오.
혹, 에러가 안나더라도 올바르게 수정해주시오.
 * */

public class Java100_variable_DataType1 {
    public static void main(String[] args) {

        //1)변수 선언
        int a; //정수가 저장될 변수 이름을 a로 만들어라
        int b;
        int c = 90;
        double d; //실수가 저장될 변수
        char e;  //문자가 저장될 변수

        //2)선언된 변수에 값을 대입
        a = 10;
        d = 10; //정수 10을 입력하면 10.0으로 출력
        e = 'A'; //문자 1개는 홑따옴표로 감싸주기. 쌍따옴표하면 에러
        b=3;
        //3)출력력
       System.out.println( a );
        System.out.println( b ); //선언하고 초기화하지 않았기 때문에 에러난다
        System.out.println( c );
        System.out.println( d );
        System.out.println( e );

        //4)여러 개 변수 선언 및 초기화 --> 선언 후 값을 세팅한다는 의미
        //4-1. 변수 선언만
        int w;
        //System.out.println(w); //변수 선언만 하고 초기화하지 않은 상태에서 출력하려고 하면 에러남
        //4-2.
        int x,y,z=900; //z만 초기화가 되고 x,y는 초기화 안됨
        int x1=300,y1=400,z1=500;//선언하면서 초기화
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(z1);

        //4-3.같은 값으로 초기화
        String str1,str2,str3;
        //str1,str2,str3="hello";  --> 에러 발생
        str1=str2=str3="hello";
        System.out.println(str1+", "+str2+", "+str3);
   }
}
