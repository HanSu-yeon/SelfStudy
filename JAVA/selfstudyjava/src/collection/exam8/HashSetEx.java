package collection.exam8;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * HashSet에 Student객체를 저장하려고 함. 학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶다
 * Student클래스에서 재정의해야 한느 hashCOde()와 equals()메소드의 내용을 채워보세요
 * Student의 해시코드는 학번이라고 가정한다
 *
 * */
public class HashSetEx {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();

        set.add(new Student(1, "홍길동"));
        set.add(new Student(2, "김길동"));
        set.add(new Student(1, "박길동")); //학번이 같으므로 저장되지 않음

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.studentNum + " : " + student.name);
        }
    }
}
