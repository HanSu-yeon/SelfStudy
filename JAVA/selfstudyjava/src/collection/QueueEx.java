package collection;

import java.util.*;

public class QueueEx {
    public static void main(String[] args) {
        System.out.println("------------------------");

        Queue<Integer> queue = new LinkedList<>(); //LinkedList로 초기화
        //offer(E e): Queue의 마지막에 요소를 삽입. 실패 시, false를 리턴
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(7);
        System.out.println(queue.offer(5));
        System.out.println(queue); //[1,3,2,7,5]


        System.out.println("-----------------------");

        //peek():Queue의 제일 앞(제일 먼저 저장)의 요소를 리턴
        //실패 시, 예외가 발생
        System.out.println(queue.peek());//제일 앞의 요소를 리턴
        System.out.println(queue.poll()); //제일 앞의 요소를 리턴 후 삭제
        System.out.println("queue" + queue);
        System.out.println(queue.remove());//제일 앞의 요소를 리턴 후 삭제
        System.out.println("queue" + queue);

        System.out.println("--------------------------");

        Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------------↓↓↓ PriorityQueue ↓↓↓--------------------------");

        //PriorityQueue를 초기화해주는 생성자 부분에서 괄호안에 아무것도 넣지 않으면 MinHeap(오름차순 정렬)형태로 동작하게 된다
        PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>();

        //괄호안에 Collections.reverseOrder()를 넣어주면 MaxHeap형태로 동작하게 된다
//        PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>(Collections.reverseOrder());

        //우선순위 큐의 값 추가
        priorityQueue.add(new Person("김민수", 25));
        priorityQueue.add(new Person("한수똥", 30));
        priorityQueue.add(new Person("김수똥", 30));
        priorityQueue.add(new Person("박수똥", 27));

        //우선순위 큐의 값 제거
        System.out.println("이름>>> " + priorityQueue.peek().getName() + ", 나이: " + priorityQueue.poll().getAge());
    }

    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        Person(String name, int time) {

            this.name = name;
            this.age = time;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Person person) {
            if (this.age == person.age) {
                return this.name.compareTo(person.name);
            }
            return this.age - person.age;
        }
    }

}
