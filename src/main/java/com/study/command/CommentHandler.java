package com.study.command;

import com.study.model.BoardBean;
import com.study.model.CommentBean;
import com.study.model.CommentDao;
import com.study.service.BoardDao;
import com.study.service.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommentHandler implements CommandHandler{
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        String boardId = request.getParameter("boardId");

        String content = request.getParameter("comment");

        CommentBean commentBean = new CommentBean();

        commentBean.setBoardId(Long.parseLong(boardId));
        commentBean.setContent(content);

        CommentDao commentDao = new CommentDao();

        commentDao.insertComment(commentBean);

        // 2. 뷰 페이지의 URI 리턴
        String redirectUri = "/board?cmd=get&boardId=" + boardId;

        response.sendRedirect(redirectUri);

        return null;
    }
}
