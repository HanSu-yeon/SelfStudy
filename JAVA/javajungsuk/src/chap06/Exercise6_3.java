package chap06;
//Ex6-3 ~6-4

class Exercise6_4 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름: " + s.name);
        System.out.println("총점: " + s.getTotal());
        System.out.println("평균: " + s.getAverage());

        System.out.println("s.info() = " + s.info());

    }
}


class Student {
    public String name;
    public int ban; //반
    public int no; //번호
    public int kor; //국어 점수
    public int eng; //영어 점수
    public int math; //수학 점수


    public Student() {
    }

    public Student(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getTotal() {

        return kor + eng + math;
    }

    public float getAverage() {
        return (int) (getTotal() / 3f * 10 + 0.5f) / 10f;
    }

    public String info() {
        return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
    }
}

