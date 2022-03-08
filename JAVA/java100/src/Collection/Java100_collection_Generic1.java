package Collection;


class Sample {
    //field
    private Object obj;

    //constructor
    Sample(Object x) {
        this.obj = x;
    }

    //method
    public Object getObj() {
        return obj;
    }

    void printInfo() {
        System.out.println(obj.getClass().getName()); //객체가 속하는 클래스의 정볼르 출력하는 메서드
    }
}

public class Java100_collection_Generic1 {
    public static void main(String[] args) {
        //1. 객체 생성 --> String
        Sample s1 = new Sample("안녕하세요");
        System.out.println(s1.getObj());
        s1.printInfo();

        //2.객체 생성-->숫자
        Sample s2 = new Sample(100);
        System.out.println(s2.getObj());
        s2.printInfo();

        //3.객체 생성-->Object
        Sample s3 = new Sample(new Object());
        s3.printInfo();
        System.out.println(s3.getObj());

        //4.위와 같이 사용시 --> 단점
        //s1 -->문자열
        String str = (String) s1.getObj(); //리턴시 반환 타입이 Object이다
        System.out.println(str.length());

        //s2 --> 숫자
//        Object num = s2.getObj();
//        System.out.println((int) num + 100);

        int num = (int) s2.getObj();
        System.out.println(num + 100);
    }
}













