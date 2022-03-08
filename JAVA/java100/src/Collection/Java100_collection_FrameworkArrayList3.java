package Collection;

import java.util.ArrayList;
import java.util.Iterator;

//Iterator개념과 이를 이용하여 ArrayList요소를 순회 및 삭제하는 코드를 구현해보시오
public class Java100_collection_FrameworkArrayList3 {
    public static void main(String[] args) {
        //1.객체 생성
        ArrayList<String> list = new ArrayList<>();
        //2.요소 추가 -->add()
        list.add("Alligator");
        list.add("Hippo");
        list.add("Ostrich");
        list.add("Donkey");

        //3.Iterator(반복자) 객체 생성 --> 객체 생성 과정도 중요!
//        System.out.println(hasNext()); /Err
        //Collection 인터페이스 --> iterator()메서드를 정의하고 있고 이를 상속받는게 List,Set인터페이스이므로,
        //List, Set 인터페이스를 상속받아 구현한 클래스들 객체를 통해서 iterator()메서드를 사용해서 객체를 생성
        Iterator<String> iter = list.iterator();

        //4.Iterator(반복자) 메서드 사용 --> hasNext(), next(),remove()
//        System.out.println(iter.hasNext());         //true -->왜? -->첫번째 요소인 Alligator가 있으니까
//        System.out.println(iter.next());            //Alligator
//
//        System.out.println(iter.hasNext());         //true -->왜? -->두번째 요소인 Hippo가 있으니까
//        System.out.println(iter.next());
//
//        System.out.println(iter.hasNext());
//        System.out.println(iter.next());
//        System.out.println(iter.hasNext());
//        System.out.println(iter.next());
//        System.out.println(iter.hasNext());         //false -->왜? -->다음 요소가 없어서
        //System.out.println(iter.next());            //에러남

        System.out.println("-------------------------------------");
        //5.향상된 for문으로 요소 출력
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("----while반복문 사용해 요소 출력---------");
        while (iter.hasNext()) {
            String str = iter.next();
            if ("Hippo".equals(str)) {
                iter.remove();
                System.out.println("하마 삭제");
            }

//            System.out.println(iter.next());
        }

        for (String s : list) {
            System.out.println(s);
        }


    }
}
