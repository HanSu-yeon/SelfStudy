package chap05;

public class ArrayEx2 {
    public static void main(String[] args) {
        String[] names = new String[]{"Kim", "Park", "Yi"};

        for (int i = 0; i < names.length; i++) {
            System.out.println("name["+i+"]"+names[i]);
        }

        String tmp = names[2]; //배열의 names의 세변째 요소를 tmp에 저장
        System.out.println("tmp = " + tmp);

        for(String str:names) //향상된 for문
            System.out.println("str = " + str);

    }
}
