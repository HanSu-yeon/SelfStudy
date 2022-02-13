package chap11.sec01;

public class StringIndexEx {
    public static void main(String[] args) {
        String subject = "c 프로그래밍";
        int location = subject.indexOf("프로그래밍");
        System.out.println(location);

        if (subject.indexOf("자바") != -1) {
            System.out.println("자바와 관련된 책이다");
        } else {
            System.out.println("자바와 관련없는 책");
        }

        if (subject.contains("자바")) {
            System.out.println("자바와 관련된 책이다");
        } else {
            System.out.println("자바와 관련없는 책");
        }

        //문자열 대치하기(replace())
        String oldStr = "자바는 객체 지향 언어다";
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println(oldStr);
        System.out.println(newStr);

        //문자열 잘라내기(substring())
        String ssn = "880805-1234567";

        String firstNum = ssn.substring(0, 6);
        String secondNum = ssn.substring(7);
        System.out.println(firstNum);
        System.out.println(secondNum);

        //알파벳 소,대문자 변경(toLowerCase(), toUpperCase())
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";
        System.out.println(str1.equals(str2));

        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        System.out.println(lowerStr2.equals(lowerStr2));

        System.out.println(str1.equalsIgnoreCase(str2));

        //문자열 앞뒤 공백 잘라내기(trim())
        String tel1 = "  02";
        String tel2 = "123   ";
        String tel3 = "  1234    ";

        String tel = tel1.trim() + tel2.trim() + tel3.trim();
        System.out.println(tel);

        //문자열 변환(valueOf())
        String string1 = String.valueOf(10);
        String string2 = String.valueOf(10.5);
        String string3 = String.valueOf(true);

        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
    }
}
