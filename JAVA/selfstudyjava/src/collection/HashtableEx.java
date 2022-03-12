package collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

//키보드로 아이디와 비밀번호를 입력받아서, Hashtable에 저장되어 있는 키(아이디)와 값(비밀번호)를 비교한 후로그인 여부를 출력하는 예제
//아이디와 비밀번호 검사하기
public class HashtableEx {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<String, String>();

        map.put("spring", "12");
        map.put("summer", "123");
        map.put("fall", "1234");
        map.put("winter", "12345");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.println("아이디: ");
            String id = scanner.nextLine();
            System.out.println("비밀번호: ");
            String password = scanner.nextLine();
            System.out.println();

            if (map.containsKey(id)) { //id인 키가 존재하는지 확인
                if (map.get(id).equals(password)) { //비밀번호를 비교
                    System.out.println("로그인되었습니다");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다");
            }
        }
    }

}
