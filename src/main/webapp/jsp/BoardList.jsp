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
<h1>자유게시판 - 목록</h1>
<form action="board?cmd=list&startDate=${startdate}&endDate=${endDate}&category=${categoryId}&keyword=${keyword}" method="get">
    <input type="hidden" name="cmd" value="list">
    <table class="search">
        <tr>
            <td>등록일</td>
            <td><input type="date" name="startDate" value="yyyy-mm-dd"> ~ <input type="date" name="endDate" value="yyyy-mm-dd"></td>
            <td>
                <select name="category">
                    <option value="ALL">전체 카테고리</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.categoryId}" name="categoryId">${category.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td> <input type="text" id="searchBox" name="keyword" placeholder="검색어를 입력해 주세요.(제목 + 작성자 + 내용)"></td>
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
            <td>${board.attached ? 'O' : ''}</td>
            <td><a href="BoardInfo.jsp?boardId=${board.boardId}" style="text-decoration:none;">${board.title}</a></td>
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
        <c:set var="startPage" value="1"/>

        <c:if test="${currentPage % 10 != 0}">
            <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true"/>
            <c:set var="startPage" value="${result * 10 + 1}"/>
        </c:if>
        <c:if test="${currentPage % 10 == 0}">
            <c:set var="startPage" value="${(result - 1) * 10 + 1}"/>
        </c:if>

        <c:set var="pageBlock" value="10" />
        <c:set var="endPage" value="${startPage + pageBlock - 1}" /> 

        <c:if test="${endPage > pageCount}">
            <c:set var="endPage" value="${pageCount}" />
        </c:if>

        <a href="board?cmd=list&pageNum=1&startDate=${startDate != null ? startDate : ''}&endDate=${endDate != null ? endDate : ''}&category=${categoryId != null ? categoryId : ''}&keyword=${keyword != null ? keyword : ''}"><<</a>
        <c:if test="${startPage > 10}">
            <a href="board?cmd=list&pageNum=${startPage - 10}&startDate=${startDate != null ? startDate : ''}&endDate=${endDate != null ? endDate : ''}&category=${categoryId != null ? categoryId : ''}&keyword=${keyword != null ? keyword : ''}"><</a>
        </c:if>
        <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <a href="board?cmd=list&pageNum=${i}&startDate=${startDate != null ? startDate : ''}&endDate=${endDate != null ? endDate : ''}&category=${categoryId != null ? categoryId : ''}&keyword=${keyword != null ? keyword : ''}">${i}</a>
        </c:forEach>
        <a href="board?cmd=list&pageNum=${endPage.intValue()}&startDate=${startDate != null ? startDate : ''}&endDate=${endDate != null ? endDate : ''}&category=${categoryId != null ? categoryId : ''}&keyword=${keyword != null ? keyword : ''}">>></a>
    </c:if>
    <button id="post" onclick="location.href='BoardWriteForm.jsp'">등록</button>
</p>
</body>
</html>
