// static 선언이 안되어있는 메서드를 사용하는 방법에 대해서 코드로 구현해보시오.
// 이 문제는 메인 메서드에서 static 선언이 없는 메서드를 사용하는 방법에 대해서 아는지를 묻는 문제이다.


public class Java100_method_Ex06 {
    public void helloWorld(){
        System.out.println("Hello, World~");
    }

    public static void main(String[] args) {
        Java100_method_Ex06 hello = new Java100_method_Ex06();
        hello.helloWorld();
    }
}
