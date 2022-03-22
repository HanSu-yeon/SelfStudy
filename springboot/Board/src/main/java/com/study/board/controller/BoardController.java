package com.study.board.controller;

import com.study.board.constant.Method;
import com.study.board.domain.BoardDTO;
import com.study.board.paging.Criteria;
import com.study.board.service.BoardService;
import com.study.board.util.UiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController extends UiUtils {

    @Autowired
    private BoardService boardService;


    //새 글을 등록하는 경우에는 idx가 필요하지x -->required속성을 false로 지정
    @GetMapping(value = "/board/write.do")
    public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        //게시글 리스트 페이지에서 게시글 등록 페이지로 이동하면 idx는 null로 전송됨
        if (idx == null) {
            //BoardDTO객체를 board라는 이름으로 뷰(화면)으로 전달
            //idx가 전송되지 않으면 빈 객체를 전달
            model.addAttribute("board", new BoardDTO());
        } else {
            //idx가 전송된 경우에는 getBoardDetail메서드의 실행결과, 즉 게시글 정보를 포함하고 있는 객체를 전달
            //게시글 상세 페이지에서 수정하기 버튼을 클릭하면 컨트롤러로 전달받은 게시글 idx를 getBoardDetail메서드의 인자로 전달
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board == null) {
                return "redirect:/board/list.do";
            }
            model.addAttribute("board", board);
        }

        return "board/write";
    }

    @PostMapping(value = "/board/register.do")
    public String registerBoard(final BoardDTO params, Model model) {
        try {
            boolean isRegistered = boardService.registerBoard(params);
            if (isRegistered == false) {
                //게시글 등록에 실패하였다는 메세지를 전달
                return showMessageWithRedirect("게시글 등록에 실패하였습니다", "/board/list.do", Method.GET, null, model);
            }
        } catch (DataAccessException e) {
            //데이터베이스 처리 과정에서 문제가 발생하였다는 메시지 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에서 문제가 발생하였습니다","/board/list.do",Method.GET,null, model);
        } catch (Exception e) {
            //시스템에서 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다","/board/list.do",Method.GET,null,model);
        }
        return showMessageWithRedirect("게시글 등록이 완료되었습니다","/board/list.do",Method.GET,null,model);
    }

    @GetMapping(value = "/board/list.do")
    public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
        List<BoardDTO> boardList = boardService.getBoardList(params);
        model.addAttribute("boardList",boardList);
        return "board/list";
    }

    //특정 게시글 조회 페이지 처리 메서드
    @GetMapping(value = "/board/view.do")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            //TODO 올바르지 않은 접근이라는 메세지 전달하고, 게시글 리스트로 리다이렉트

            return "redirect:/board/list.do";
        }

        BoardDTO board = boardService.getBoardDetail(idx);
        if(board == null || "Y".equals(board.getDeleteYn())){
            //TODO 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트

            return "redirect:/board/list.do";
        }

        model.addAttribute("board", board);
        return "board/view";
    }

    @PostMapping(value = "/board/delete.do")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            //올바르지 않은 접근이라는 메시지를 전달하고 게시글 리스트로 리다이렉트
            return showMessageWithRedirect("올바르지 않은 접근입니다", "/board/list.do", Method.GET, null, model);
        }

        try {
            boolean isDeleted = boardService.deleteBoard(idx);
            if (isDeleted == false) {
                //게시글 삭제에 실패하였다는 메시지를 전달
                return showMessageWithRedirect("게시글 삭제에 실패하였습니다", "/board/list.do", Method.GET, null, model);

            }
        } catch (DataAccessException e) {
            //데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에서 문제가 발생하였습니", "/board/list.do", Method.GET, null, model);

        } catch (Exception e) {
            //시스템에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다","/board/list.do",Method.GET,null,model);
        }
        return showMessageWithRedirect("게시글 삭제가 완료되었습니다","/board/list.do",Method.GET,null,model);
    }
}
