<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>게시판 보기</title>
</head>
<body>
<script type="text/javascript">
  // url 파라미터 지우는 코드
  history.replaceState({}, null, location.pathname);

  // 쿠키에서 값을 가져오는 함수
  function getCookie(name) {
    var value = '; ' + document.cookie;
    var parts = value.split('; ' + name + '=');

    if (parts.length === 2) {
      var cookieValue = parts.pop().split(';').shift();
      return decodeURIComponent(cookieValue);
    }
    return null;
  }
</script>
<h2>게시판 - 보기</h2>
  <table>
    <tr>
      <td>${boardBean.writer}</td>
      <td class="rightAlign">등록일시 ${boardBean.createdAt}</td>
      <td class="rightAlign">수정일시${boardBean.modifiedAt != null ? boardBean.modifiedAt : '-'}</td>
    </tr>
    <tr class="title">
      <td colspan="3">[${categoryName}] ${boardBean.title}</td>
      <td class="rightAlign">조회수: ${boardBean.views}</td>
    </tr>
    <tr class="content-row">
      <td colspan="4" class="content">${boardBean.content}</td>
    </tr>
    <c:forEach var="fileBean" items="${fileList}">
      <tr>
        <td colspan="4">
          <a download href="/upload/${fileBean.savedName}">
              ${fileBean.originalName}
          </a>
        </td>
      </tr>
    </c:forEach>
    <c:forEach var="commentBean" items="${commentList}">
      <tr class="comment">
        <td colspan="4">
          ${commentBean.createdAt}
          <br>
          ${commentBean.content}
        </td>
      </tr>
    </c:forEach>
    <form action="board/comment?cmd=write&boardId=${boardBean.boardId}" method="post">
    <tr class="commentEnd">
      <td colspan="3"><textarea rows="2" cols="250" name="comment" placeholder="댓글을 입력해주세요."></textarea></td>
      <td><button type="submit">등록</button> </td>
    </tr>
    </form>
    <tr>
      <td class="buttons" colspan="4">
        <button onclick="location.href='board' +
        '?cmd=list' +
        '&pageNum=' + (getCookie('pageNum') || '') +
        '&startDate=' + (getCookie('startDate') || '') +
        '&endDate=' + (getCookie('endDate') || '') +
        '&categoryId=' + (getCookie('categoryId') || '') +
        '&keyword=' + (getCookie('keyword') || '')">목록
        </button>
        <button onclick="location.href='board?cmd=modify&boardId=${boardBean.boardId}'">수정</button>
        <button onclick="location.href='board?cmd=validate&boardId=${boardBean.boardId}'">삭제</button>
      </td>
    </tr>
  </table>
</body>
</html>
