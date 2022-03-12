package collection.exam8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//HashMap에 아이디(String)와 점수(Integer)가 저장되어 있다
//평균 점수를 출력하고, 최고 점수와 최고 점수를 받은 아이디를 출력해라
public class MapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null; //최고 점수 받은 아이디 저장
        int maxScore = 0;   //최고 점수 저장
        int totalScore = 0; //점수 합계 저장

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                name = entry.getKey();
            }
            totalScore += entry.getValue();
        }
        System.out.println("최고점수: " + maxScore);
        System.out.println("최고점수를 받은 아이디 = " + name);
        System.out.println("평균: " + totalScore / map.size());

    }
}
