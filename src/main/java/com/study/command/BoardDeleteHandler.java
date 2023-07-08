package com.study.command;

import com.study.model.BoardBean;
import com.study.service.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시글 삭제를 처리하는 핸들러입니다.
 */
public class BoardDeleteHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        String boardId = request.getParameter("boardId");

        String password = request.getParameter("password");

        BoardBean boardBean = new BoardBean();

        boardBean.setBoardId(Long.parseLong(boardId));
        boardBean.setPassword(password);

        BoardDao boardDao = new BoardDao();

        boolean isValidated = boardDao.validatePassword(boardBean);

        if (isValidated) {
            boardDao.deleteBoard(boardId);

            return "/board?cmd=list";
        } else {
            return "/board?cmd=validate&boardId=" + boardId;
        }
    }
}
