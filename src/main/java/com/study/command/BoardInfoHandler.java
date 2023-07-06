package com.study.command;

import com.study.model.BoardBean;
import com.study.service.CategoryDao;
import com.study.model.CommentBean;
import com.study.service.CommentDao;
import com.study.service.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardInfoHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        String boardId = request.getParameter("boardId");

        BoardDao boardDao = new BoardDao();

        boolean updateView = false;

        BoardBean boardBean = boardDao.getOneBoard(boardId, false);

        CommentDao commentDao = new CommentDao();

        List<CommentBean> commentList = commentDao.getComments(boardId);

        CategoryDao categoryDao = new CategoryDao();

        String categoryName = categoryDao.getCategoryName(boardBean.getCategoryId());

        // 2. 뷰 페이지에서 사용할 정보 저장
        request.setAttribute("boardBean", boardBean);
        request.setAttribute("commentList", commentList);
        request.setAttribute("categoryName", categoryName);

        // 3. 뷰 페이지의 URI 리턴
        return "/jsp/BoardInfo.jsp";
    }
}
