package collection;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {


    public List<Board2> getBoardList() {
        List<Board2> list = new ArrayList<Board2>();
        list.add(new Board2("제목1", "내용1"));
        list.add(new Board2("제목2", "내용2"));
        list.add(new Board2("제목3", "내용3"));
        list.add(new Board2("제목4", "내용4"));
        list.add(new Board2("제목5", "내용5"));
        return list;
    }
}
