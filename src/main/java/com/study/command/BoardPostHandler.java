package com.study.command;

import com.study.model.BoardBean;
import com.study.service.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.Collection;

import static com.study.util.FileUploadUtil.uploadFiles;

public class BoardPostHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        BoardDao boardDao = new BoardDao();

        BoardBean boardBean = new BoardBean();

        String writer = request.getParameter("writer");

        String password = request.getParameter("password");

        String password2 = request.getParameter("password2");

        String title = request.getParameter("title");

        String content = request.getParameter("content");

        String categoryIdParam = request.getParameter("categoryId");

        // 작성자 필수, 글자 수 검증
        if (writer == null || writer.length() < 3 || writer.length() >= 5) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        }

        // 비밀번호 필수, 글자 수, 패턴 검증
        if (password == null || password.length() < 4 || password.length() >= 16 || !password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]+$")) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        }

        // 비밀번호 확인 일치 검증
        if (!password.equals(password2)) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        }

        // 제목 필수, 글자 수 검증
        if (title == null || title.length() < 4 || title.length() >= 100) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        }

        // 내용 필수, 글자 수 검증
        if (content == null || content.length() < 4 || content.length() >= 2000) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        }

        // 카테고리 필수 선택 검증
        long categoryId = 0L;
        if (categoryIdParam == null || categoryIdParam.equals("ALL")) {
            response.sendRedirect(request.getContextPath() + "/board?cmd=write");
        } else {
            try {
                categoryId = Long.parseLong(categoryIdParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        boardBean.setCategoryId(categoryId);
        boardBean.setWriter(writer);
        boardBean.setPassword(password);
        boardBean.setTitle(title);
        boardBean.setContent(content);

        long boardId = boardDao.insertBoard(boardBean);
    
        // 파일 업로드
        Collection<Part> parts = request.getParts();

        String realPath = request.getServletContext().getRealPath("/upload");

        uploadFiles(realPath, parts, boardId);

        return "/board?cmd=get&boardId=" + boardId;
    }
}
