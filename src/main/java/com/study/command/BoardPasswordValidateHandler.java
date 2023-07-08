package com.study.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 패스워드를 검증 처리하는 핸들러입니다
 */
public class BoardPasswordValidateHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        String boardId = request.getParameter("boardId");

        // 2. 뷰 페이지에서 사용할 정보 저장
        request.setAttribute("boardId", boardId);

        // 3. 뷰 페이지의 URI 리턴
        return "/jsp/PasswordValidate.jsp";
    }
}
