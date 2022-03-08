package Collection;

import java.util.ArrayList;

public class Java100_collection_Collection1 {
    public static void main(String[] args) {
        //1.ArrayList를 제네릭이 아닌 Object 타입으로 사용하는 경우
        ArrayList list1 = new ArrayList();

        //2.데이터 추가하기 -->add()
        list1.add("홍길동"); //문자열 자료형 저장
        list1.add(20); //정수 자료형 저장
        list1.add("이순신");
        list1.add(20); //데이터 중복이 가능
      

        //3. 데이터 가져오기 --> get() --> 이때, 해당 데이터 자료형으로 형변환하여 사용한다(불편)
        //System.out.println(list1.get(0)); 홍길동
        String str = (String) list1.get(0);
        System.out.println(str.length());
        int n1 = (Integer) list1.get(1);
        System.out.println(n1);

        //결론
        //이상으로 봤을때, 제네릭 문법을 사용하지 않으면 ArrayList는 내부적으로 Object타입으로 처리됨을 알 수 있다
        //이렇게 get()메서드를 사용할 때는 형변환을 주의하자 --> 제네릭을 사용하자
        System.out.println("--------------------------");
        System.out.println(list1.size());
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i) + "");
            System.out.println();
        }
    }
}
