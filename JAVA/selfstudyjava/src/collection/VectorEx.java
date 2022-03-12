package collection;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        Vector<Board> list = new Vector<Board>();

        //Board 객체를 저장
        list.add(new Board("제목1", "내용1", "글쓴1"));
        list.add(new Board("제목2", "내용2", "글쓴2"));
        list.add(new Board("제목3", "내용3", "글쓴3"));
        list.add(new Board("제목4", "내용4", "글쓴4"));
        list.add(new Board("제목5", "내용5", "글쓴5"));

        list.remove(2);
        list.remove(3);

        for (int i = 0; i < list.size(); i++) {
            Board board = list.get(i);
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }
    }
}
