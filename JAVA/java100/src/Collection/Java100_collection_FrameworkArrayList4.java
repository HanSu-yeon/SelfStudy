package Collection;

//Iterator(반복자)를 쓰는 이유

/* [!]컬렉션 프레임워크를 쓸 때 한번 이상은 꼭 만나게 되는 에러 메세지 -->java.util.ConcurrentModificationException
 * 이 오류 메세지는 보통 컬렉션 list요소를 반복문 안에서 돌리면서 값을 삭제하고자 할 때 발생
 * 보통 반복문 안에서 remove()메서드를 호출할 때 발생
 * 그 외에도, Iterator(반복자) 객체의 생성 순서에 따라서도 발생-->아무튼 다양하다
 *
 * 한행씩 삭제하는 경우에는 별 문제가 없으나 --> 반복문 안에서 순회하면서 삭제시에는..
 * 반복문 들어가기 전의 기존 list배열의 size(length)나 index 정보 등이 변경되면서 --> 순회시 정보가 맞지 않아 오류가 발생
 * 이를 해결하기 위해서는 -->Iterator(반복자)를 사용하여 순회하고 --> 그때, iter.remove()메서드로 처리해야야한다
 *
 * */


import java.util.ArrayList;
import java.util.Iterator;

public class Java100_collection_FrameworkArrayList4 {
    public static void main(String[] args) {
        //1. 객체 생성
        ArrayList<Integer> list = new ArrayList<>();

        //2.요소 추가 -->add()
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //3.Iterator(반복자)객체 생성
        Iterator<Integer> it = list.iterator();

        //4.출력 -->요소 삭제 전
        for (Integer num : list) {
            System.out.println(num + "");
        }
        System.out.println();

        //5-1. 요소 삭제 -->반복문 없이 한개의 요소만 삭제
//        System.out.println(list.get(1)); //2
//        list.remove(1); //2삭제
//        System.out.println(list.get(1));

        //5-2 요소 삭제 -->while 반복문 사용
        System.out.println("-------------------------");

        //for (Integer i : list)
        //   list.remove(i);//err발생
        //System.out.print(i + "");

        while (it.hasNext()) {
            Integer i = it.next();
            if (i == 2) {
                it.remove();
                System.out.println(i + "번 삭제");
            }
        }
        System.out.println("-------------------------");
        //6. 출력 -->요소 삭제 후
        for (Integer num : list)
            System.out.println(num);

    }

}



