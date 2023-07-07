package com.study.command;

import com.study.model.BoardBean;
import com.study.service.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        BoardDao boardDao = new BoardDao();

        BoardBean boardBean = new BoardBean();

        String boardId = request.getParameter("boardId");

        String writer = request.getParameter("writer");

        String password = request.getParameter("password");

        String title = request.getParameter("title");

        String content = request.getParameter("content");

        boardBean.setBoardId(Long.parseLong(boardId));
        boardBean.setWriter(writer);
        boardBean.setPassword(password);
        boardBean.setTitle(title);
        boardBean.setContent(content);

        boolean validatePassword = boardDao.validatePassword(boardBean);

        // 작성자 필수, 글자 수 검증
        if (writer == null || writer.length() < 3 || writer.length() >= 5) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=get&boardId=" + boardId);
        }

        // 비밀번호 확인 일치 검증
        if (!validatePassword) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=get&boardId=" + boardId);
        }

        // 제목 필수, 글자 수 검증
        if (title == null || title.length() < 4 || title.length() >= 100) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=get&boardId=" + boardId);
        }

        // 내용 필수, 글자 수 검증
        if (content == null || content.length() < 4 || content.length() >= 2000) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=get&boardId=" + boardId);
        }

        boardDao.updateBoard(boardBean);

        return "/board?cmd=get&boardId=" + boardId;
    }
}
