<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/css/board-info.css" type="text/css">
  <title>게시판 보기</title>
</head>
<body>
<h2>게시판 - 보기</h2>
  <table>
    <tr>
      <td>${categoryName}</td>
      <td class="rightAlign">등록일시 ${boardBean.createdAt}</td>
      <td class="rightAlign">수정일시${boardBean.modifiedAt != null ? boardBean.modifiedAt : '-'}</td>
    </tr>
    <tr class="title">
      <td colspan="3">[${boardBean.categoryId}] ${boardBean.title}</td>
      <td class="rightAlign">조회수: ${boardBean.views}</td>
    </tr>
    <tr class="content-row">
      <td colspan="4" class="content">${boardBean.content}</td>
    </tr>
    <tr>
      <td colspan="4">
        첨부파일
        <br>
        첨부파일
        <br>
        첨부파일
        <br>
      </td>
    </tr>

    <c:forEach var="commentBean" items="${commentList}">
      <tr class="comment">
        <td colspan="4">
          ${commentBean.createdAt}
          <br>
          ${commentBean.content}
        </td>
      </tr>
    </c:forEach>
    <form action="CommentWriteProc.jsp?boardId=${boardBean.boardId}" method="post">
    <tr class="commentEnd">
      <td colspan="3"><textarea rows="2" cols="250" name="comment" placeholder="댓글을 입력해주세요."></textarea></td>
      <td><button type="submit">등록</button> </td>
    </tr>
    </form>
    <tr>
      <td class="buttons" colspan="4">
        <button onclick="location.href='BoardList.jsp'">목록</button>
        <button onclick="location.href='BoardUpdateForm.jsp?boardId='${boardBean.boardId}">수정</button>
        <button onclick="location.href='PasswordValidate.jsp?boardId=${boardBean.boardId}'">삭제</button>
      </td>
    </tr>
  </table>
</body>
</html>
