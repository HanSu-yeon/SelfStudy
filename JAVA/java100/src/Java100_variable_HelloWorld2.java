// 자바의 기본적인 코드 구성에서 각 키워드를 간략히 설명해보시오.
// 이 문제는 자바 코드의 주요 키워드들에 대해서 각각의 의미와 쓰임새(용도)에 대해서 아는지를 묻는 문제이다.
public class Java100_variable_HelloWorld2 {
    public static void main(String[] args) {
        System.out.println( "Hello World~" );
    }
}
/**

 접근제한자 클래스선언 클래스이름 {
      접근제한자 static 반환타입 메서드이름(파라미터) {
          //구현할 코드 작성
      }
 }

 (1)접근제한자 --> public, private, protected, default
             -클래스나 메서드에 접근할 수 있는 범위를 지정 =>접근제한자, 접근제어자
             -private > protected > public

(2)클래스선언 -->class
            -객체를 생성하는 틀, 프레임, 공장, 템플릿
(3)클래스이름 --> 카멜케이스(단어와 단어 사이의 구분을 대문자로)
(4)메서드이름 --> 메서드란? 함수 =>어떤 특정한 동작이나 작업, 행위 등을 수행하는 것

 */