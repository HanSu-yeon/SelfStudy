package collection.exam8;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<Message>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSNS", "김길동"));
        messageQueue.offer(new Message("sendKakao", "박길동"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();

            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게" + message.command + "하세요");
                    break;
                case "sendSNS":
                    System.out.println(message.to + "님에게" + message.command + "하세요");
                    break;
                case "sendKakao":
                    System.out.println(message.to + "님에게" + message.command + "하세요");
                    break;


            }

        }
    }
}
