package collection;

import java.util.HashMap;
import java.util.Map;

//학번과 이름이 동일한 경우 같은 키로 인식
public class HashMapEx2 {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<Student, Integer>();

        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);

        System.out.println("map.size() = " + map.size()); //저장된 총 Map.Entry 수 얻기
    }
}
