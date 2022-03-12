package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//이름을 키로 점수를 값으로 저장하기
public class HashMapEx {
    public static void main(String[] args) {
        //Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<String, Integer>();

        //객체 저장
        map.put("홍길동", 30);
        map.put("김길동", 20);
        map.put("강길동", 10);
        map.put("박길동", 40);
        map.put("김길동", 50); //김길동이라는 키는 이미 있어서 제일 마지막에 저장한 값으로 대체
        System.out.println("총 Entry 수 = " + map.size());

        //객체 찾기
        System.out.println("\t홍길동: " + map.get("김길동")); //이름(키)로 점수(값)를 검색
        System.out.println();

        //객체를 하나씩 처리
        Set<String> keySet = map.keySet(); //Key Set얻기
        Iterator<String> keyIterator = keySet.iterator();  //반복해서 키를 얻고 값을 Map에서 얻어냄
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + ": " + value);
        }
        System.out.println();

        //객체 삭제
        map.remove("김길동"); //키로 Map.Entry를 제거
        System.out.println("총 Entry수: " + map.size());

        //객체를 하나씩 처리
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); //Map.Entry Set얻기
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        //객체 전체 삭제
        map.clear(); //모든 Map.Entry삭제

        System.out.println("map.size() = " + map.size());

    }
}
