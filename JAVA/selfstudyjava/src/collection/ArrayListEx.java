package collection;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("JDBC");
        list.add("servlet/jsp");
        list.add(2, "database");
        list.add("ibatis");

        int size = list.size();
        System.out.println("총 객체수" + size);
        System.out.println();

        String skill = list.get(2); //2번 인덱스의 객체 얻기
        System.out.println("2 = " + skill);
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ": " + str);

        }
        System.out.println();

        list.remove(2); //database 삭제
        list.remove(2); //servlet/jsp
        list.remove("ibatis");

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + " : " + str);
        }


    }
}
