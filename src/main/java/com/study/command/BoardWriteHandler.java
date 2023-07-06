package com.study.command;

import com.study.model.CategoryBean;
import com.study.service.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardWriteHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리
        CategoryDao categoryDao = new CategoryDao();

        List<CategoryBean> categoryList = categoryDao.getAllCategories();
        // 2. 뷰 페이지에서 사용할 정보 저장
        request.setAttribute("categoryList", categoryList);
        // 3. 뷰 페이지의 URI 리턴
        return "/jsp/BoardWriteForm.jsp";
    }
}
