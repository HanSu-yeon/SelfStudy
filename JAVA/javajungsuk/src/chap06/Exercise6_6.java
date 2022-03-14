package chap06;

//Ex 6-6 ~ 6-7
class MyPoint {
    int x;
    int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //인스턴스메서드 getDistance를 작성하시오
    public double getDistance(int x1, int y1) {
        double a = Math.pow((x - x1), 2);
        double b = Math.pow((y - y1), 2);

        return Math.sqrt(a + b);
    }
}

class Exercise6_6 {
    public static void main(String[] args)
    {
        MyPoint p = new MyPoint(1, 1);

        System.out.println(p.getDistance(2, 2));
    }
}
