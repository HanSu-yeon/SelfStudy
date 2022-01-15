package com.board.util;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;

//공통 컨트롤러


@Controller
public class UiUtils {
    public String showMessageWithRedirect(
            @RequestParam(value = "message", required = false) String message, //사용자에게 전달할 메세지
            @RequestParam(value = "redirectUri", required = false) String redirectUri, //
            @RequestParam(value = "method", required = false) Method method, //HTTP 요청 메소드
            @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) { //화면(view)로 전달할 파라미터
        //model: 화면(view)으로 파라미터 전달하는데 사용
        model.addAttribute("message", message);
        model.addAttribute("redirectUri", redirectUri);
        model.addAttribute("method", method);
        model.addAttribute("params", params);

        return "utils/message-redirect";


    }
}
	

