package collection;

import java.util.List;

/*
 *BoardDao객체의 getBoardList() 메소드를 호출하면 List<Board>타입의 컬렉션을 리턴한다
 */
//BoardDao 사용 클래스
public class ListEx2 {
    public static void main(String[] args) {
        BoardDao dao = new BoardDao();
        List<Board2> list = dao.getBoardList();
        for (Board2 board : list) {
            System.out.println(board.getTitle() + "-" + board.getContent());
        }
    }
}
