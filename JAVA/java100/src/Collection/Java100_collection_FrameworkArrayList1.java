package Collection;

import java.util.ArrayList;

//ArrayList를 이용한 자료의 추가, 수정, 삭제, 출력을 구현해보시오
public class Java100_collection_FrameworkArrayList1 {
    public static void main(String[] args) {
        //0.ArrayList객체 생성 -->제네릭을 사용
        ArrayList<String> ar = new ArrayList<String>();

        //1.추가 --> add()
        ar.add("홍길동");
        ar.add("김길동");
        ar.add("강길동");
        ar.add("박길동");
        ar.add("이길동");
        System.out.println(ar.get(3));
        String str = ar.get(0); //형변환 없이 바로 사용 -> 타입 안전성↑

        //2.수정-->set(인덱스, 수정값)
        ar.set(3, "징기스칸");
        System.out.println(ar.get(3));

        //3.삭제 -->2가지(하나만 삭제/ 한꺼번에 삭제) -->remove(인덱스)
        ar.remove(3);
        System.out.println(ar.size());

        //4.출력
        for (String str2 : ar)
            System.out.println(str2);

        //5.출력2
        for (int i = 0; i < ar.size(); i++)
            System.out.printf("%d번 학생의 이름은 %s입니다%n", (i + 1), ar.get(i));

//            System.out.println(ar.get(i));

        //6.한꺼번에 삭제 --> removeAll(배열명)
        ar.removeAll(ar);
        System.out.println(ar.size());
        System.out.println("전체 삭제 후 출력");
        for (String str3 : ar)
            System.out.println(str3);
        System.out.println("전체 삭제 후 출력");

    }
}
