package Collection;


class Sample2<T> {
    //field
    private T obj;

    //constructor
    Sample2(T x) {
        this.obj = x;
    }

    //method
    T getObj() {
        return obj;
    }

    void printInfo() {
        System.out.println(obj.getClass().getName());
    }
}

public class Java100_collection_Generic2 {
    public static void main(String[] args) {
        //1.객체 생성 -->String
        Sample2<String> s1 = new Sample2<String>("안녕하세요");
        System.out.println(s1.getObj());
        s1.printInfo();
        System.out.println("-------------------------------");

        //2.객체 생성 -->Integer
        Sample2<Integer> s2 = new Sample2<Integer>(100);
        System.out.println(s2.getObj());
        s2.printInfo();

        //3.형변환 없이 사용하기
        String str = s1.getObj();
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(s1.getObj().length());

        System.out.println(s2.getObj());
    }
}
