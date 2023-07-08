package com.study.command;

import com.study.model.CommentBean;
import com.study.service.CommentDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 댓글을 작성하는 핸들러입니다.
 */
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
        return "/board?cmd=get&boardId=" + boardId;
    }
}
