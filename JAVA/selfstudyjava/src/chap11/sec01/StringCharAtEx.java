package chap11.sec01;

//주민등록번호에서 7번째 인덱스 문자를 읽어 남자와 여자를 구별
public class StringCharAtEx {
    public static void main(String[] args) {
        String ssn = "010624-1230123";
        char sex = ssn.charAt(7);

        switch (sex) {
            case '1':
            case '3':
                System.out.println("남자입니다");
                break;
            case '2':
            case '4':
                System.out.println("여자");
                break;
        }


    }
}
