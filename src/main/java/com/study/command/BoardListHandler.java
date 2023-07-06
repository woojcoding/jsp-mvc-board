package com.study.command;

import com.study.model.BoardBean;
import com.study.model.BoardSearchCondition;
import com.study.model.CategoryBean;
import com.study.service.CategoryDao;
import com.study.service.BoardDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardListHandler implements CommandHandler{
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 명령어와 관련된 비즈니스 로직 처리

        //페이지 네이션
        int pageSize = 10;

        String pageNum = request.getParameter("pageNum");

        if (pageNum == null || pageNum.isEmpty()) {
            pageNum = "1";
        }

        int currentPage = Integer.parseInt(pageNum);

        BoardDao boardDao = new BoardDao();

        int startRow = (currentPage - 1) * pageSize + 1;

        int endRow = currentPage * pageSize;

        // 검색 조건
        String startDate = request.getParameter("searchStartDate");

        String endDate = request.getParameter("searchEndDate");

        String categoryId = request.getParameter("searchCategory");
        
        String keyword = request.getParameter("searchKeyword");

        BoardSearchCondition boardSearchCondition =
                new BoardSearchCondition(startDate, endDate, categoryId, keyword);

        // 검색된 총 게시글 수
        int totalBoardCount = boardDao.getBoardCount(boardSearchCondition);

        List<BoardBean> boardList = boardDao.getBoards(boardSearchCondition, startRow, endRow);

        CategoryDao categoryDao = new CategoryDao();

        List<CategoryBean> categoryList = categoryDao.getAllCategories();

        Map<Long, String> categoryMap = new HashMap<>();

        for (CategoryBean categoryBean : categoryList) {

            categoryMap.put(categoryBean.getCategoryId(), categoryBean.getName());
        }

        // 2. 뷰 페이지에서 사용할 정보 저장
        request.setAttribute("boardList", boardList);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalBoardCount", totalBoardCount);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("categoryMap", categoryMap);

        // 3. 뷰 페이지의 URI 리턴
        return "/jsp/BoardList.jsp";
    }
}
