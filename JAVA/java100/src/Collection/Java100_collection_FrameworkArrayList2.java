package Collection;

import java.util.ArrayList;

//컬렉션 프레임워크 ArrayList 기반으로 2차원 배열을 만들어 요소를 추가하고 출력해보시오
public class Java100_collection_FrameworkArrayList2 {
    public static void main(String[] args) {
        //1.객체 생성
        ArrayList<Integer[]> arr = new ArrayList<Integer[]>();
        //2.요소 추가-->add()
        arr.add(new Integer[]{1, 2, 3, 4});
        arr.add(new Integer[]{11, 12, 13});
        arr.add(new Integer[]{21, 22, 23, 24});

        //3.요소출력
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i)[0]); //1,11,21
        }
        //4.전체 요소 출력 --> 이중 반복문 --> 그런데 그전에 안쪽 배열의 사이즈를 미리 체크 --> 여기서 약간 주의!
//        System.out.println(arr.get(0).size()); //Err -->컬렉션 프레임워크 타입의 길이를 알고 싶을 때 사용
//        System.out.println(arr.get(0).length()); //Err -->문자열의 길이를 알고 싶을 때 사용
        System.out.println(arr.get(1).length); //4 -->배열(int[],Integer[],String[])의 길이를 알고 싶을 때 사용

        //5.전체 요소 출력
        System.out.println("------------------------------------");
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length; j++) {
                System.out.print(arr.get(i)[j] + ", ");
            }
            System.out.println();
        }
    }

}
