package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;
import com.board.domain.BoardDTO;
import com.board.service.BoardService;
import com.board.util.UiUtils; //UiUtils 상속

//컨트롤러(Presentation Layer) 처리하기
@Controller //사용자의 요청과 응답을 처리하는 즉 UI를 담당하는 컨트롤러 클래스임을 의미
public class BoardController extends UiUtils {

    @Autowired
    private BoardService boardService;

    /*@RequestParam:뷰(화면)에서 전달받은 파라미터를 처리하는 데 사용된다*/
    //리턴타입=> 대표적으로 String과 ModelAndView는 사용자에게 보여줄 화면(HTML경로)을 리턴문에 지정해서 처리. 최근 String을 많이 선호
    //글쓰기페이지
    @GetMapping(value = "/board/write.do") // URI 매핑처리. 이전 버전 스프링에서는 @RequestMapping 이용
    public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) { //메소드의 파라미터로 지정된 Model인터페이스는 데이터를 뷰로 전달하는 데 사용된다

		/*addAttribute(String name,Object value) 이 메소드를 이용해 화면(HTML)으로 데이터를 전달할 수 있다.
		웬만하면 name과 value를 동일하게 지정한다. HTML에서는 ${}표현식을 이용해 전달받은 데이터에 접근할 수 있다
		*/
        if (idx == null) { //게시글 번호(idx)가 전송되지 않은 경우에는 비어있는 객체를 전달
            model.addAttribute("board", new BoardDTO());
        } else { //게시글 번호(idx)가 전송된 경우에는 getBoardDetail메소드의 실행 결과, 즉 게시글 정보를 포함하고 있는 객체를 전달함
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board == null) { //메소드 실행 결과가 null이면
                return "redirect:/board/list.do";
            }
            model.addAttribute("board", board);
        }
        return "board/write";  //컨트롤러 처리가 마무리되면 메서드의 리턴 타입으로 지정된 경로에 화면(HTML)을 생성해야 한다
    }

    //params의 멤버 변수에는 게시글 작성 페이지에서 입력한 제목,이름,내용의 "name"속성과 일치한, 즉 게시글 등록 페이지에 입력한 값이 매핑(바인딩)되어 있다
    @PostMapping(value = "/board/register.do")
    public String registerBoard(final BoardDTO params, Model model) {
        try {
            boolean isRegistered = boardService.registerBoard(params);
            if (isRegistered == false) {
                //게시글 등록에 실패했다는 메시지 전달
                return showMessageWithRedirect("게시글 등록에 실패했다", "/board/list.do", Method.GET, null, model);
            }
        } catch (DataAccessException e) {
            //데이터베이스 처리 과정에서 문제가 발생했다는 메시지 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에 문제 발생", "/board/list.do", Method.GET, null, model);
        } catch (Exception e) {
            //시스템에 문제가 발생했다는 메시지 전달
            return showMessageWithRedirect("시스템에 문제가 발생", "/board/list.do", Method.GET, null, model);
        }
        return showMessageWithRedirect("게시글 등록 완료", "/board/list.do", Method.GET, null, model);//예외 발생하면 게시글 리스트 페이지로 리다이렉트

    }

    //컨트롤러의 리턴 타입이 String이면 리턴문에 지정된 경로의 HTML이 화면에 출력된다
    @GetMapping(value = "/board/list.do")
    public String opendBoardList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList(); //getBoardList 메서드의 실행 결과를 boardList에 담아 뷰로 전달
        model.addAttribute("boardList", boardList); //컨트롤러에서 화면(view)으로 데이터를 전달하는데 사용되는 인터페이스

        return "board/list"; //== src/main/resources>templates/board/list.html

    }

    //게시글 조회
    /*@RequestParam: 특정 게시글 조회에 필요한 게시글 번호(idx)를 파라미터로 전달받음
     * required: 파라미터 필수값 여부*/
    @GetMapping(value = "/board/view.do")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        //idx가 파라미터로 전달x
        if (idx == null) {
            //TODO=> 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list.do";
        }

        //정상적인 경우
        BoardDTO board = boardService.getBoardDetail(idx);
        if (board == null || "Y".equals(board.getDeleteYn())) {
            //TODO=> 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list.do";
        }
        model.addAttribute("board", board);
        return "board/view";
    }

    //삭제
    @PostMapping(value = "/board/delete.do")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            // TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return showMessageWithRedirect("올바르지 않은 접근", "redirect:/board/list.do", Method.GET, null, model);

        }

        try {
            boolean isDeleted = boardService.deleteBoard(idx);
            if (isDeleted == false) {
                // TODO => 게시글 삭제에 실패하였다는 메시지를 전달
                return showMessageWithRedirect("게시글 삭제 실패", "redirect:/board/list.do", Method.GET, null, model);
            }
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에서 문제 발생", "redirect:/board/list.do", Method.GET, null, model);

        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("시스템에 문제 발생", "redirect:/board/list.do", Method.GET, null, model);
        }

        return "redirect:/board/list.do";
    }


}
