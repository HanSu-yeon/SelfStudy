package Oop;

/*１．인터페이스: 추상 클래스와 거의 비슷하나 그 추상화 정도가 더 높다(더 엄격) --> 일반 메서드나 멤버 필드(변수)를 가질 수 없다
            표준화 및 규격을 인터페이스로 제공 --> 일종의 "설계도"개념
            추상 클래스와 같이 메서드의 구체적인 내용은 기술되어져 있지 않으므로 어떤 클래스가 인터페이스를 사용(상속)한다면　인터페이스를　상속받은　클래스에서　재정의（오버라이딩）하여　사용
            인터페이스는　interface키워드를　사용
  2. 상속：
      - 클래스는　＂단일　상속＂만　가능，　인터페이스는　＂다중　상속＂이　가능(콤마로 분리)
      - 즉, 이를 이용하면 여러개의 인터페이스로부터 메서드를 받아올 수 있게 된다 --> 다중 상속 구현

  3. 장점
    - 인터페이스를 이용하면 메소드의 추상적인 '선언'과 그 메서드들을 구체적인 '구현'부분을 분리시킬 수 있다
    - 하청을 주는 대기업(값)은 하청업체(을)에 인터페이스만 제공 --> 각 하청업체(을)들이 이를 준수하여(=상속 받아)개발
    - 분업화된 시스템을 구축하여 "갑"과 "을"이 독립적으로 프로젝트 개발을 해나갈 수 있다 --> 매우 큰 장점

  4. 우선 순위(extends vs implements)
  - 상속을 받는 extends 키워드와 구현을 하는 implements 키워드가 동시에 쓰일때 --> extends키워드가 항상 먼저 쓰인다
  - 예) class Student extends Person implements A,B
*/

class Person6 {
    //Field
    String name;
    int age;
    int weight;

    //Constructor
    Person6() {
    }

    Person6(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    //Method
    void wash() {
        System.out.println("씻다");
    }

    void study() {
        System.out.println("공부하다");
    }

    void play() {
        System.out.println("놀다");
    }
}

interface Allowance {
    //Field
    //변수는 안되나 상수는 되므로 상수로 지정해주면 됨 --> public static final을 붙여주면 됨
    //인터페이스내 모든 멤버 필드(변수)는 public static final이여야 함 -->즉, 생략이 가능하다
    public static final String aaa = "코리아";
    int bbb = 100;

    //Abstract Method
    //인터페이스내 모든 메서드는 public abstract 이어야 함 --> 생략이 가능
    void in(int price, String name);

    abstract void out(int price, String name); //{}내용 없이 선언만(괄호까지만) 되어있어야 한다

//    void wash() { System.out.println("씻다");}  -->{}내용이 들어 있어서 에러가 난다
}

interface Train {
    abstract void train(int training_pay, String name);

}

class Student extends Person6 implements Allowance, Train {
    //Field
    //Constructor
    Student() {
    }

    Student(String name, int age, int weight) {
        super(name, age, weight);
    }

    //Method
    public void in(int price, String name) {
        System.out.printf("%s한테 %d원 용돈을 받았습니다", name, price);
    }

    public void out(int price, String name) {
        System.out.printf("%d원 금액을 지출했습니다. [지출용도-->%s]", price, name);
    }

    public void train(int training_pay, String name) {
        System.out.printf("[%s -->%d원 입금완료]", name, training_pay);
    }

}

public class Java100_ex09 {
    public static void main(String[] args) {
        //객체 생성
//        Student2 s1 = new Student2("홍길동", 20, 80);
//
//        s1.wash();
//        s1.study();
//        s1.play();
//        s1.in(10000, "엄마");
//        s1.out(5000, "편의점");
//        s1.train(20000, "훈련비");
    }
}
