package Oop;


class Person4 {
    //Feild
    private String name;
    private int age;

    //Constructor
    Person4() {
    }

    Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Method
    public String getName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }
}


public class Java100_ex06 {
    public static void main(String[] args) {
        //객체 생성
        int[] ar1 = {1, 2, 3, 4, 5};
        char[] ar2 = {'A', 'B', 'C', 'D', 'E'};
        Person5[] personArray = new Person5[5]; //객체를 5개 저장할 수 있는 배열을 만든다
        personArray[0] = new Person5("홍길동", 20);
        personArray[1] = new Person5("김길동", 21);
        personArray[2] = new Person5("박길동", 22);
        personArray[3] = new Person5("이길동", 23);
        personArray[4] = new Person5("오길동", 24);

        //출력
        for (int i = 0; i < ar1.length; i++) {
            System.out.print(ar1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < personArray.length; i++) {
            System.out.print(personArray[i] + ", ");
            System.out.print(personArray[i].getName() + ", ");
            System.out.print(personArray[i].getAge());
            System.out.println();

        }
    }
}
