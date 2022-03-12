package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//ArrayList와 LinkedList에 10,000개의 객체를 삽입하는 데 걸린 시간을 측정해 이 둘의 실행 성능 비교
public class LinkedListEx {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }

        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간  = " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간= " + (endTime - startTime) + "ns");
    }
}
