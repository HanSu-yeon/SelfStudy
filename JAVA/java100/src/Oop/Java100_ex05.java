package Oop;

// getter, setter가 포함된 클래스의 상속을 코드로 구현해보시오.
// 이 문제는 클래스의 상속을 구현시 getter, setter의 개념과 용도를 알고 있는지를 묻는 문제이다.
// 부모 클래스 --> Person3, 자식 클래스 --> Villain2, Hero2
/*
----------------------------

        악당 이름 : 좀비
        악당 나이 : 20 살
        악당의 키 : 180 Cm
        악당 체중 : 80 Kg
        악당 넘버 : 15001231
        악당 무기 : 창
        악당 파워 : 99.5
        ----------------------------
        좀비 이동중..
        ----------------------------
        악당 이름 : 도깨비
        악당 나이 : 30 살
        악당의 키 : 175 Cm
        악당 체중 : 70 Kg
        악당 넘버 : 11001121
        악당 무기 : 방패
        악당 파워 : 140.5
        ----------------------------
        도깨비 이동중..
        ----------------------------
        악당 이름 : 몽달귀신
        악당 나이 : 40 살
        악당의 키 : 150 Cm
        악당 체중 : 40 Kg
        악당 넘버 : 14001011
        악당 무기 : ---
        악당 파워 : 11.5
        ----------------------------
        몽달귀신 이동중..
 */

class Person3 {
    /**
     * 필드
     */
    //필드들을 외부에서 마음대로 변경 하지 못하게 하기 위해 private로 하기 --> 이 클래스 내에서만 변경/수정 가능 외부에서는 getter,setter로만 접근 가능
    private String name;
    private int age;
    private int height;
    private int weight;


    /**
     * 생성자
     */
    Person3() {
    }

    Person3(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 메서드
     */
    //1.getter 반환되는 값이 있으므로 리턴 타입을 적어준다 그리고 인자도 필요없음(호출만 하면 된다)
    public String getName() {
        return name;
    }

    //2.setter 값 세팅시에는 반환되는 값이 없음
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = weight;
    }

    public void move() {
        System.out.println("이동중...");
    }
}

class Villain2 extends Person3 {
    //빌런만 가지는 특징/속성들 정의
    //필드
    String unique_key;
    int weapon; //1~9숫자로 무기 분류
    double power;

    //생성자
    Villain2() {
    }

    Villain2(String name, int age, int height, int weight, String unique_key, int weapon, double power) {
        super(name, age, height, weight);
        this.unique_key = unique_key;
        this.weapon = weapon;
        this.power = power;
    }

    //메서드
    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    //printPerson()
    public void printPerson() {

        System.out.println("----------------------------");
        System.out.println("악당 이름: " + getName());
        System.out.println("악당 나이: " + getAge());
        System.out.println("악당 키: " + getHeight());
        System.out.println("악당 체중: " + getWeight());
        System.out.println("악당 넘버: " + getUnique_key());
        System.out.println("악당 무기: " + getWeaponName(getWeapon()));
        System.out.println("악당 파워: " + getPower());
        System.out.println("----------------------------");

    }

    //getWeaponName()
    public String getWeaponName(int weaponNum) {
        String weapon;
        switch (weaponNum) {
            case 1:
                weapon = "창";
                break;
            case 2:
                weapon = "방패";
                break;
            case 3:
                weapon = "총";
                break;
            default:
                weapon = "---";
                break;
        }
        return weapon;
    }
}

class Hero2 extends Person3 {
}


public class Java100_ex05 {
    public static void main(String[] args) {
        //객체 생성
        Person3 p1 = new Person3();
        p1.setName("홍길동");
        System.out.println(p1.getName());

        Villain2 v1 = new Villain2("좀비", 20, 180, 80, "15001231", 2, 99.5);
        v1.printPerson();
        System.out.print(v1.getName() + " ");
        v1.move();


        Villain2 v2 = new Villain2("도깨비", 30, 170, 70, "15221231", 1, 80.5);
        v2.printPerson();
        System.out.print(v2.getName() + " ");
        v2.move();
    }

}
