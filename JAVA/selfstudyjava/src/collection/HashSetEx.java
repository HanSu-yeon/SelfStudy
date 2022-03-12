package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//HashSet에 String 객체를 추가, 검색, 제거하는 방법
//String 객체를 중복 없이 저장하는 HashSet
public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java"); //중복은 하나만 저장
        set.add("jdbc");
        set.add("abcd");
        set.add("Java");
        set.add("hijk");

        int size = set.size();
        System.out.println("총객체수 = " + size);


        Iterator<String> iterator = set.iterator(); //반복자 얻기
        while (iterator.hasNext()) {  //객체 수만큼 루핑
            String element = iterator.next(); //1개의 객체를 가져옴
            System.out.println("\t" + element);
        }

        set.remove("jdbc");
        set.remove("hijk");

        System.out.println("총 객체 수 =" + set.size());


        iterator = set.iterator(); //반복자 얻기
        //객체수만큼 루핑
        for (String element : set) {
            System.out.println("\t" + element);
        }

        set.clear(); //모든 객체를 제거하고 비움
        if (set.isEmpty()) {
            System.out.println("비어 있음");
        }
    }

}
