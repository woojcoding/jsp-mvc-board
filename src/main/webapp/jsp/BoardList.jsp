<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-06-26
  Time: AM 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
</head>
<body>
<%--<script type="text/javascript">--%>
<%--    // url 파라미터 지우는 코드--%>
<%--    history.replaceState({}, null, location.pathname);--%>
<%--</script>--%>
<script type="text/javascript">
    function saveFormDataToCookie() {
        var startDate = document.getElementById("startDate").value;

        var endDate = document.getElementById("endDate").value;

        var categoryId = document.getElementById("categoryId").value;

        var keyword = document.getElementById("keyword").value;

        // 쿠키에 저장
        document.cookie = "startDate=" + startDate + "; path=/";

        document.cookie = "endDate=" + endDate + "; path=/";

        document.cookie = "categoryId=" + categoryId + "; path=/";

        document.cookie = "keyword=" + keyword + "; path=/";
    }

    function savePageNumToCookie(pageNum) {
        document.cookie = "pageNum=" + pageNum + "; path=/";
    }
</script>
<h1>자유게시판 - 목록</h1>
<form action="board" method="get" onsubmit="saveFormDataToCookie()">
    <input type="hidden" name="cmd" value="list">
    <table class="search">
        <tr>
            <td>등록일</td>
            <td><input type="date" id="startDate" name="startDate" value="${param.startDate}"> ~ <input type="date" id="endDate" name="endDate" value="${param.endDate}"></td>
            <td>
                <select id="categoryId" name="categoryId">
                    <option value="ALL">전체 카테고리</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.categoryId}" name="categoryId">${category.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td> <input type="text" id="keyword" name="keyword" placeholder="검색어를 입력해 주세요.(제목 + 작성자 + 내용)" value="${param.keyword}"></td>
            <td><button type="submit">검색</button></td>
        </tr>
    </table>
</form>
<br>총 ${totalBoardCount}건
<table class="boardList">
    <tr>
        <td>카테고리</td>
        <td>첨부</td>
        <td>제목</td>
        <td>작성자</td>
        <td>조회수</td>
        <td>등록 일시</td>
        <td>수정 일시</td>
    </tr>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${categoryMap[board.categoryId]}</td>
            <td>
            <c:set var="fileList" value="${fileDao.getFiles(board.boardId)}" />
            <c:choose>
                <c:when test="${fileList != null && fileList.size() > 0}">
                    O
                </c:when>
                <c:otherwise>
                    X
                </c:otherwise>
            </c:choose>
        </td>
            <td><a href="board?cmd=get&boardId=${board.boardId}" style="text-decoration:none;">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>${board.views}</td>
            <td>${board.createdAt}</td>
            <td>${board.modifiedAt != null ? board.modifiedAt : '-'}</td>
        </tr>
    </c:forEach>
</table>
<p id="paging">
    <c:if test="${totalBoardCount > 0}">
        <c:set var="pageCount" value="${totalBoardCount / pageSize + (totalBoardCount % pageSize == 0 ? 0 : 1)}" />
        <c:set var="startPage" value="1" />

        <c:if test="${currentPage > 10}">
            <c:set var="startPage" value="${currentPage - ((currentPage - 1) % 10)}" />
        </c:if>

        <c:set var="endPage" value="${startPage + 9}" />
        <c:if test="${endPage > pageCount}">
            <c:set var="endPage" value="${pageCount}" />
        </c:if>

        <a href="board?cmd=list&pageNum=1&startDate=${param.startDate}&endDate=${param.endDate}&category=${param.category}&keyword=${param.keyword}" onclick="savePageNumToCookie(1)"><<</a>
        <c:if test="${startPage > 10}">
            <a href="board?cmd=list&pageNum=${startPage - 10}&startDate=${param.startDate}&endDate=${param.endDate}&category=${param.category}&keyword=${param.keyword}" onclick="savePageNumToCookie(${startPage - 10})"><</a>
        </c:if>
        <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <a href="board?cmd=list&pageNum=${i}&startDate=${param.startDate}&endDate=${param.endDate}&category=${param.category}&keyword=${param.keyword}" onclick="savePageNumToCookie(${i})">${i}</a>
        </c:forEach>
        <a href="board?cmd=list&pageNum=${endPage.intValue()}&startDate=${param.startDate}&endDate=${param.endDate}&category=${param.category}&keyword=${param.keyword}" onclick="savePageNumToCookie(${endPage.intValue()})">>></a>
    </c:if>
    <button id="post" onclick="location.href='board?cmd=write'">등록</button>
</p>
</body>
</html>
