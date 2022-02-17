//아래의 메서드 구현 코드에서 틀린 곳을 찾아 올바르게 수정하시오.

//메서드에 static이 붙어있으면 클래스명.메서드명();으로 호출할 수 있다
//static은 static을 부를 수 있다 main메소드가 static이기 때문에 helloWorld메서드에도 static을 붙여준다
public class Java100_method_Ex01 {
    public static void helloWorld(){
        System.out.println("Hello, World~^_^");
    }

    public static void main(String[] args){
        //1)메서드 호출
        helloWorld();  //이렇게 객체 생성 없이 메서드를 호출하고 싶으면 이 메서드가 들어있는 클래스에 static을 붙여준다
    }
}
