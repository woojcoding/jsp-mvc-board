package com.study.command;

import com.study.model.BoardBean;
import com.study.model.FileBean;
import com.study.service.BoardDao;
import com.study.service.CategoryDao;
import com.study.service.FileDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardModifyHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        String boardId = request.getParameter("boardId");

        boolean updateViews = false;

        BoardDao boardDao = new BoardDao();

        BoardBean boardBean = boardDao.getOneBoard(boardId, updateViews);

        CategoryDao categoryDao = new CategoryDao();

        String categoryName = categoryDao.getCategoryName(boardBean.getCategoryId());

        FileDao fileDao = new FileDao();

        List<FileBean> fileList = fileDao.getFiles(Long.parseLong(boardId));

        // 2. 뷰 페이지에서 사용할 정보 저장
        request.setAttribute("boardBean", boardBean);
        request.setAttribute("categoryName", categoryName);
        request.setAttribute("fileList", fileList);
        // 3. 뷰 페이지의 URI 리턴
        return "/jsp/BoardUpdateForm.jsp";
    }
}
